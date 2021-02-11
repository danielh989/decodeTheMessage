import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DecodeMessageTest {

    @Test
    void isPossibleEncodedMessage() {
        assertTrue(DecodeMessage.isPossibleEncodedMessage("BANANA", "COLOLO"));
        assertFalse(DecodeMessage.isPossibleEncodedMessage("BANANA", "COLOL"));
    }

    @Test
    void isPossibleEncodedMessageSameLength() {
        assertFalse(DecodeMessage.isPossibleEncodedMessage("BANANA", "COLOLA"));
        assertFalse(DecodeMessage.isPossibleEncodedMessage("BANANA", "XXXXXX"));
        assertFalse(DecodeMessage.isPossibleEncodedMessage("XXXXXX", "BANANA"));
    }

    @Test
    void isPossibleEncodedMessageNullInput() {
        assertFalse(DecodeMessage.isPossibleEncodedMessage(null, "COLOLO"));
        assertFalse(DecodeMessage.isPossibleEncodedMessage("BANANA", null));
    }
}