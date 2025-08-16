package br.eti.souza.i18n;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Obter mensagens internacionalizada.
 * @author Alan Moraes Souza
 */
public class Messages {

    /** Logger para esta classe. */
    private final static Logger LOGGER = Logger.getLogger(Messages.class.getName());
    /** Cache das fontes de mensagens. */
    private final static ThreadLocal<Locale> LOCALE = new ThreadLocal<>();
    /** Cache das fontes de mensagens. */
    private final static Map<Locale, ResourceBundle> CACHE = new HashMap<>();

    /**
     * Define a localidade da fonte de mensagens para a thread.
     * @param locale Localidade.
     */
    public static void setLocale(Locale locale) {
        Messages.LOCALE.set(locale == null ? Locale.getDefault() : locale);
    }

    /**
     * Obter a localidade da fonte de mensagens para a thread.
     * @return Localidade.
     */
    private static Locale getLocale() {
        var locale = Messages.LOCALE.get();
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return locale;
    }

    /**
     * Obter a fonte de mensagens de acordo com a localidade definida para a thread.
     * Se localidade da thread não foi definida, usa java.util.Locale.getDefault().
     * @return Fonte de mensagens.
     */
    private static ResourceBundle getResourceBundle() {
        var locale = Messages.getLocale();
        if (!Messages.CACHE.containsKey(locale)) {
            try {
                Messages.CACHE.put(locale, ResourceBundle.getBundle("messages", locale));
            } catch (MissingResourceException e) {
                Messages.LOGGER.log(Level.WARNING, e.getMessage());
                return null;
            }
        }
        return Messages.CACHE.get(locale);
    }

    /**
     * Obter mensagem pela chave.
     * @param key Chave da mensagem.
     * @return Mensagem.
     */
    public static String get(String key) {
        try {
            return Messages.getResourceBundle().getString(key);
        } catch (NullPointerException e) {
            return "### " + Messages.getLocale().toLanguageTag() + " ###";
        } catch (MissingResourceException e) {
            Messages.LOGGER.log(Level.WARNING, e.getMessage());
            return "### " + key + " ###";
        }
    }

    /**
     * Obter mensagem pela chave com definição de argumentos.
     * @param key Chave da mensagem.
     * @param args Argumentos da mensagem.
     * @return Mensagem.
     */
    public static String get(String key, String... args) {
        var message = Messages.get(key);
        for (var i = 0; i < args.length; i++) {
            message = message.replaceAll("\\{" + i + "\\}", args[i]);
        }
        return message;
    }

    /**
     * Obter mensagem pela mensagem internacionalizada.
     * @param message Mensagem internacionalizada.
     * @return Mensagem.
     */
    public static String get(Message message) {
        return Messages.get(message.getKey(), message.getArgs());
    }
}
