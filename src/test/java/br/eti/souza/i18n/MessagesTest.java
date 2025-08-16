package br.eti.souza.i18n;

import java.util.Locale;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testes da classe br.eti.souza.i18n.Messages.
 * @author Alan Moraes Souza
 */
public class MessagesTest {

    /** Garante que o locale padrão é pt-BR. */
    @BeforeEach
    public void BeforeEach() {
        Locale.setDefault(Locale.of("pt", "BR"));
    }

    /** Teste obter com Locale invalido sem messages padrão. */
    @Test
    public void getByInvalidLocale() {
        Locale.setDefault(Locale.FRANCE);
        Messages.setLocale(Locale.FRANCE);
        Assertions.assertEquals("### fr-FR ###", Messages.get("key"));
    }

    /** Teste obter pela chave invalida. */
    @Test
    public void getByInvalidKey() {
        Assertions.assertEquals("### key.invalid ###", Messages.get("key.invalid"));
        Messages.setLocale(Locale.ENGLISH);
        Assertions.assertEquals("### key.invalid ###", Messages.get("key.invalid"));
        Messages.setLocale(Locale.of("es"));
        Assertions.assertEquals("### key.invalid ###", Messages.get("key.invalid"));
        Messages.setLocale(Locale.of("es", "MX"));
        Assertions.assertEquals("### key.invalid ###", Messages.get("key.invalid"));
        Messages.setLocale(Locale.of("pt", "BR"));
        Assertions.assertEquals("### key.invalid ###", Messages.get("key.invalid"));
    }

    /** Teste obter pela chave. */
    @Test
    public void getByKey() {
        Assertions.assertEquals("Chave", Messages.get("key"));
        Messages.setLocale(Locale.ENGLISH);
        Assertions.assertEquals("Key", Messages.get("key"));
        Messages.setLocale(Locale.of("es"));
        Assertions.assertEquals("Clave", Messages.get("key"));
        Messages.setLocale(Locale.of("es", "MX"));
        Assertions.assertEquals("ClaveMexico", Messages.get("key"));
        Messages.setLocale(Locale.of("pt", "BR"));
        Assertions.assertEquals("Chave", Messages.get("key"));
    }

    /** Teste obter pela chave com argumentos. */
    @Test
    public void getByKeyWithArgs() {
        Assertions.assertEquals("arg0 Chave arg1", Messages.get("key.args", "arg0", "arg1"));
        Messages.setLocale(Locale.ENGLISH);
        Assertions.assertEquals("arg0 Key arg1", Messages.get("key.args", "arg0", "arg1"));
        Messages.setLocale(Locale.of("es"));
        Assertions.assertEquals("arg0 Clave arg1", Messages.get("key.args", "arg0", "arg1"));
        Messages.setLocale(Locale.of("es", "MX"));
        Assertions.assertEquals("arg0 ClaveMexico arg1", Messages.get("key.args", "arg0", "arg1"));
        Messages.setLocale(Locale.of("pt", "BR"));
        Assertions.assertEquals("arg0 Chave arg1", Messages.get("key.args", "arg0", "arg1"));
    }
    @Test
    public void getByInvaildKeyWithArgs() {
        Assertions.assertEquals("### key.invalid ###", Messages.get("key.invalid", "arg0", "arg1"));
        Messages.setLocale(Locale.ENGLISH);
        Assertions.assertEquals("### key.invalid ###", Messages.get("key.invalid", "arg0", "arg1"));
        Messages.setLocale(Locale.of("es"));
        Assertions.assertEquals("### key.invalid ###", Messages.get("key.invalid", "arg0", "arg1"));
        Messages.setLocale(Locale.of("es", "MX"));
        Assertions.assertEquals("### key.invalid ###", Messages.get("key.invalid", "arg0", "arg1"));
        Messages.setLocale(Locale.of("pt", "BR"));
        Assertions.assertEquals("### key.invalid ###", Messages.get("key.invalid", "arg0", "arg1"));
    }

    /** Teste obter pela chave com argumentos repetido. */
    @Test
    public void getByKeyWithSameArgs() {
        Assertions.assertEquals("arg0 Chave arg0", Messages.get("key.same.args", "arg0", "arg1"));
        Messages.setLocale(Locale.ENGLISH);
        Assertions.assertEquals("arg0 Key arg0", Messages.get("key.same.args", "arg0", "arg1"));
        Messages.setLocale(Locale.of("es"));
        Assertions.assertEquals("arg0 Clave arg0", Messages.get("key.same.args", "arg0", "arg1"));
        Messages.setLocale(Locale.of("es", "MX"));
        Assertions.assertEquals("arg0 ClaveMexico arg0", Messages.get("key.same.args", "arg0", "arg1"));
        Messages.setLocale(Locale.of("pt", "BR"));
        Assertions.assertEquals("arg0 Chave arg0", Messages.get("key.same.args", "arg0", "arg1"));
    }

    /** Teste obter pela mensagem internacionalizada. */
    @Test
    public void getByMessage() {
        Assertions.assertEquals("### key.invalid ###", Messages.get(new Message("key.invalid")));
        Assertions.assertEquals("Chave", Messages.get(new Message("key")));
        Assertions.assertEquals("### key.invalid ###", Messages.get(new Message("key.invalid", "arg0", "arg1")));
        Assertions.assertEquals("arg0 Chave arg1", Messages.get(new Message("key.args", "arg0", "arg1")));
        Assertions.assertEquals("arg0 Chave arg0", Messages.get(new Message("key.same.args", "arg0", "arg1")));
        Messages.setLocale(Locale.ENGLISH);
        Assertions.assertEquals("### key.invalid ###", Messages.get(new Message("key.invalid", "arg0")));
        Assertions.assertEquals("Key", Messages.get(new Message("key")));
        Assertions.assertEquals("### key.invalid ###", Messages.get(new Message("key.invalid", "arg0", "arg1")));
        Assertions.assertEquals("arg0 Key arg1", Messages.get(new Message("key.args", "arg0", "arg1")));
        Assertions.assertEquals("arg0 Key arg0", Messages.get(new Message("key.same.args", "arg0", "arg1")));
        Messages.setLocale(Locale.of("es"));
        Assertions.assertEquals("### key.invalid ###", Messages.get(new Message("key.invalid")));
        Assertions.assertEquals("Clave", Messages.get(new Message("key")));
        Assertions.assertEquals("### key.invalid ###", Messages.get(new Message("key.invalid", "arg0", "arg1")));
        Assertions.assertEquals("arg0 Clave arg1", Messages.get(new Message("key.args", "arg0", "arg1")));
        Assertions.assertEquals("arg0 Clave arg0", Messages.get(new Message("key.same.args", "arg0", "arg1")));
        Messages.setLocale(Locale.of("es", "MX"));
        Assertions.assertEquals("### key.invalid ###", Messages.get(new Message("key.invalid")));
        Assertions.assertEquals("ClaveMexico", Messages.get(new Message("key")));
        Assertions.assertEquals("### key.invalid ###", Messages.get(new Message("key.invalid", "arg0", "arg1")));
        Assertions.assertEquals("arg0 ClaveMexico arg1", Messages.get(new Message("key.args", "arg0", "arg1")));
        Assertions.assertEquals("arg0 ClaveMexico arg0", Messages.get(new Message("key.same.args", "arg0", "arg1")));
        Messages.setLocale(Locale.of("pt", "BR"));
        Assertions.assertEquals("### key.invalid ###", Messages.get(new Message("key.invalid")));
        Assertions.assertEquals("Chave", Messages.get(new Message("key")));
        Assertions.assertEquals("### key.invalid ###", Messages.get(new Message("key.invalid", "arg0", "arg1")));
        Assertions.assertEquals("arg0 Chave arg1", Messages.get(new Message("key.args", "arg0", "arg1")));
        Assertions.assertEquals("arg0 Chave arg0", Messages.get(new Message("key.same.args", "arg0", "arg1")));
    }
}
