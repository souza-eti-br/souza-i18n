package br.eti.souza.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Testes da classe br.eti.souza.i18n.Messages.
 * @author Alan Moraes Souza
 */
public class MessageTest {

    /** Teste do contrutor com chave. */
    @Test
    public void newWithKey() {
        var message = new Message(null);
        Assertions.assertEquals("null", message.getKey());
        Assertions.assertEquals(0, message.getArgs().length);
        message = new Message("");
        Assertions.assertEquals("", message.getKey());
        Assertions.assertEquals(0, message.getArgs().length);
        message = new Message("teste.chave");
        Assertions.assertEquals("teste.chave", message.getKey());
        Assertions.assertEquals(0, message.getArgs().length);
    }

    /** Teste do contrutor com chave e argumentos. */
    @Test
    public void newWithKeyAngArgs() {
        var message = new Message(null, (String) null);
        Assertions.assertEquals("null", message.getKey());
        Assertions.assertEquals(1, message.getArgs().length);
        Assertions.assertEquals("null", message.getArgs()[0]);
        message = new Message("", "", null);
        Assertions.assertEquals("", message.getKey());
        Assertions.assertEquals(2, message.getArgs().length);
        Assertions.assertEquals("", message.getArgs()[0]);
        Assertions.assertEquals("null", message.getArgs()[1]);
        message = new Message("teste.chave", "arg0", "arg1");
        Assertions.assertEquals("teste.chave", message.getKey());
        Assertions.assertEquals(2, message.getArgs().length);
        Assertions.assertEquals("arg0", message.getArgs()[0]);
        Assertions.assertEquals("arg1", message.getArgs()[1]);
    }
}
