package ppppp._4_i18n;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author lppppp
 * @create 2021-01-22 9:55
 */
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        // System.out.println("自己的区域解析器");
        Locale l = null;

        String locale = request.getParameter("locale");
        // System.out.println("自己区域解析器接受的locale:"+locale);
        if (locale != null && !"".equals(locale)) {
            l = new Locale(locale.split("_")[0], locale.split("_")[1]);
        } else {
            l = request.getLocale();
        }
        // System.out.println("Locale:"+l.toString());
        return l;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {
        throw new UnsupportedOperationException("Can't set Locale message");
    }
}
