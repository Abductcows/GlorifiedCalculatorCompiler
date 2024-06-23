package utilities;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;

public class ParserBetterMessageErrorStrategy extends BailErrorStrategy {


    @Override
    public void recover(Parser recognizer, RecognitionException e) {

        var offendingToken = e.getOffendingToken();
        int line = offendingToken.getLine(), column = offendingToken.getCharPositionInLine() + 1;
        String newMessage = "In %d,%d: Found symbol \"%s\" when I was not supposed to".formatted(line, column, offendingToken.getText());
        e = new RecognitionException(newMessage, e.getRecognizer(), e.getInputStream(), (ParserRuleContext) e.getCtx());

        for (ParserRuleContext context = recognizer.getContext(); context != null; context = context.getParent()) {
            context.exception = e;
        }

        throw new ParseCancellationException(e);
    }

    @Override
    public Token recoverInline(Parser recognizer) throws RecognitionException {
        recover(recognizer, new InputMismatchException(recognizer));
        return null;
    }
}
