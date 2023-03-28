package org.mps.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mps.board.AdvertisementBoard.BOARD_OWNER;

class AdvertisementBoardTest {

    class FakePaymentGateway implements PaymentGateway {
        @Override
        public boolean advertiserHasFunds(String advertiserName) {
            return advertiserName.equals("Robin Robot");
        }

        @Override
        public void chargeAdvertiser(String advertiserName) {

        }
    }

    class DummyDatabase implements AdvertiserDatabase{
        @Override
        public boolean advertiserIsRegistered(String advertiserName) {
            return true;
        }
    }

    AdvertisementBoard advertisementBoard;

    @BeforeEach
    void setUp() {
        advertisementBoard = new AdvertisementBoard();
    }

    @Test //1
    void ThereIsAnInitialAdvertisement() {
        assertEquals(1, advertisementBoard.numberOfPublishedAdvertisements());
    }

    @Test //2
    void TheBoardOwnerCanPublishAnAdvertisement() {
        Advertisement newAdvertisement = new Advertisement("Welcome", "new Advertisement", BOARD_OWNER);
        advertisementBoard.publish(newAdvertisement,null, new FakePaymentGateway() );
        assertEquals(2, advertisementBoard.numberOfPublishedAdvertisements());
    }

    @Test //3
    void Checktheinsertcondition() {
        Advertisement newAdvertisement = new Advertisement("Hi", "Third Advertisement", "Pepe Gotera y Otilio");
        AdvertiserDatabase Database = mock(AdvertiserDatabase.class);
        when(Database.advertiserIsRegistered("Pepe Gotera y Otilio")).thenReturn(true);
        PaymentGateway paymentGateway = mock(PaymentGateway.class);
        when(paymentGateway.advertiserHasFunds("Pepe Gotera y Otilio")).thenReturn(false);
        advertisementBoard.publish(newAdvertisement,Database, paymentGateway);
        assertEquals(1, advertisementBoard.numberOfPublishedAdvertisements());
    }

    @Test //4
    void AdvertisementByRobinRobot() {
        Advertisement newAdvertisement = new Advertisement("Hi", "Third Advertisement", "Robin Robot");
        AdvertiserDatabase Database = mock(AdvertiserDatabase.class);
        when(Database.advertiserIsRegistered("Robin Robot")).thenReturn(true);
        PaymentGateway paymentGateway = mock(PaymentGateway.class);
        when(paymentGateway.advertiserHasFunds("Robin Robot")).thenReturn(true);
        advertisementBoard.publish(newAdvertisement,Database, paymentGateway);
        assertEquals(2, advertisementBoard.numberOfPublishedAdvertisements());
    }

    @Test //5
    void TheBoardOwnerCanPublishTwoAdvertisements() {
        Advertisement newAdvertisement1 = new Advertisement("Welcome", "new Advertisement", BOARD_OWNER);
        Advertisement newAdvertisement2 = new Advertisement("Hi", "new Advertisement", BOARD_OWNER);
        AdvertiserDatabase Database = mock(AdvertiserDatabase.class);
        advertisementBoard.publish(newAdvertisement1,null, new FakePaymentGateway() );
        advertisementBoard.publish(newAdvertisement2,null, new FakePaymentGateway() );
        advertisementBoard.deleteAdvertisement("Welcome", BOARD_OWNER);
        assertFalse(advertisementBoard.findByTitle("Welcome").isPresent());
    }

    @Test //6
    void TryToPublishAnExistingAdvertisement() {
        Advertisement newAdvertisement = new Advertisement("Welcome", "new Advertisement", "Robin Robot");

        AdvertiserDatabase Database = mock(AdvertiserDatabase.class);
        PaymentGateway paymentGateway = mock(PaymentGateway.class);
        Mockito.when(Database.advertiserIsRegistered("Robin Robot")).thenReturn(true);
        Mockito.when(paymentGateway.advertiserHasFunds("Robin Robot")).thenReturn(true);

        advertisementBoard.publish(newAdvertisement,Database, paymentGateway);
        advertisementBoard.publish(newAdvertisement,Database, paymentGateway);

        verify(Database, times(1)).advertiserIsRegistered("Robin Robot");
    }

    @Test //7
    void TryToPublishInFullBoard(){

        AdvertiserDatabase Database = mock(AdvertiserDatabase.class);
        PaymentGateway paymentGateway = mock(PaymentGateway.class);
        for (int i = 0; i < 19; i++){
            Advertisement newAdvertisement = new Advertisement("Welcome" + i, "new Advertisement", "Tim O'Theo");
            Mockito.when(Database.advertiserIsRegistered("Tim O'Theo")).thenReturn(true);
            Mockito.when(paymentGateway.advertiserHasFunds("Tim O'Theo")).thenReturn(true);
            advertisementBoard.publish(newAdvertisement,Database, paymentGateway);
        }

        Advertisement newAdvertisement = new Advertisement("Welcome", "new Advertisement", "Tim O'Theo");
        Mockito.when(Database.advertiserIsRegistered("Tim O'Theo")).thenReturn(true);
        Mockito.when(paymentGateway.advertiserHasFunds("Tim O'Theo")).thenReturn(true);
        assertThrows(AdvertisementBoardException.class, () -> advertisementBoard.publish(newAdvertisement,Database, paymentGateway));

    }
}