package br.eti.souza.i18n;

import java.util.ArrayList;
import java.util.List;

/**
 * Mensagem internacionalizada.
 * @author Alan Moraes Souza
 */
public class Message {

    /** Chave da mensagem. */
    private final String key;
    /** Argumentos da mensagem. */
    private final List<String> args = new ArrayList<>();

    /**
     * Construtor que define a chave da mensagem sem argumentos.
     * @param key Chave da mensagem. (se null, usa "null").
     */
    public Message(String key) {
        this.key = (key == null ? "null" : key);
    }

    /**
     * Construtor que define a chave e argumentos da mensagem.
     * @param key Chave da mensagem. (se null, usa "null").
     * @param args Argumentos da mensagem. (se algum argumento for null, usa "null").
     */
    public Message(String key, String... args) {
        this(key);
        for (var arg : args) {
            this.args.add(arg == null ? "null" : arg);
        }
    }

    /**
     * Retorna a chave da mensagem.
     * @return Chave da mensagem.
     */
    public String getKey() {
        return this.key;
    }

    /**
     * Retorna os argumentos da mensagem.
     * @return Argumentos da mensagem.
     */
    public String[] getArgs() {
        return this.args.toArray(String[]::new);
    }
}
