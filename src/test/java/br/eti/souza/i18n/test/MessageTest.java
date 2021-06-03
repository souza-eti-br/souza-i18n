package br.eti.souza.i18n.test;

import br.eti.souza.i18n.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Testes para br.eti.souza.i18n.Message
 * @author Alan Moraes Souza
 */
public class MessageTest {

    @Test
    @DisplayName("Teste do construtor com apenas chave nula")
    public void constructorWithKeyNull() {
        Message m = new Message(null);
        Assertions.assertTrue("null".equals(m.getKey()));
        Assertions.assertArrayEquals(new String[0], m.getArgs());
    }

    @Test
    @DisplayName("Teste do construtor com chave nula e um argumento nulo")
    public void constructorWithKeyNullAndArgNull() {
        Message m = new Message(null, (Object) null);
        Assertions.assertTrue("null".equals(m.getKey()));
        Assertions.assertArrayEquals(new String[]{"null"}, m.getArgs());
    }

    @Test
    @DisplayName("Teste do construtor com chave nula e dois argumentos nulos")
    public void constructorWithKeyNullAndArgsNull() {
        Message m = new Message(null, (Object) null, (Object) null);
        Assertions.assertTrue("null".equals(m.getKey()));
        Assertions.assertArrayEquals(new String[]{"null", "null"}, m.getArgs());
    }

    @Test
    @DisplayName("Teste do construtor com apenas chave vazia")
    public void constructorWithKeyEmpty() {
        Message m = new Message("");
        Assertions.assertTrue("".equals(m.getKey()));
        Assertions.assertArrayEquals(new String[0], m.getArgs());
    }

    @Test
    @DisplayName("Teste do construtor com chave vazia e um argumento vazio")
    public void constructorWithKeyEmptyAndArgEmpty() {
        Message m = new Message("", "");
        Assertions.assertTrue("".equals(m.getKey()));
        Assertions.assertArrayEquals(new String[]{""}, m.getArgs());
    }

    @Test
    @DisplayName("Teste do construtor com chave vazia e dois argumentos vazios")
    public void constructorWithKeyEmptyAndArgsEmpties() {
        Message m = new Message("", "", "");
        Assertions.assertTrue("".equals(m.getKey()));
        Assertions.assertArrayEquals(new String[]{"", ""}, m.getArgs());
    }

    @Test
    @DisplayName("Teste do construtor com apenas chave")
    public void constructorWithKey() {
        Message m = new Message("key");
        Assertions.assertTrue("key".equals(m.getKey()));
        Assertions.assertArrayEquals(new String[0], m.getArgs());
    }

    @Test
    @DisplayName("Teste do construtor com chave e um argumento texto")
    public void constructorWithKeyAndArgString() {
        Message m = new Message("key", "value");
        Assertions.assertTrue("key".equals(m.getKey()));
        Assertions.assertArrayEquals(new String[]{"value"}, m.getArgs());
    }

    @Test
    @DisplayName("Teste do construtor com chave e um argumento numérico")
    public void constructorWithKeyAndArgNumber() {
        Message m = new Message("key", 8);
        Assertions.assertTrue("key".equals(m.getKey()));
        Assertions.assertArrayEquals(new String[]{"8"}, m.getArgs());
    }

    @Test
    @DisplayName("Teste do construtor com chave e dois argumentos texto e numérico")
    public void constructorWithKeyAndArgsStringNumber() {
        Message m = new Message("key", "value", 8);
        Assertions.assertTrue("key".equals(m.getKey()));
        Assertions.assertArrayEquals(new String[]{"value", "8"}, m.getArgs());
    }
}
