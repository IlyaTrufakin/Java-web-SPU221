package itstep.learning.ioc;

import itstep.learning.filters.*;
import com.google.inject.servlet.ServletModule;
import itstep.learning.servlets.*;

public class WebModule extends ServletModule {
    @Override
    //регистрируем фильтры
    protected void configureServlets() {
        filter("/*").through(CharsetFilter.class);

        // и сервлеты
        serve("/").with(HomeServlet.class);
        serve("/db").with(DbServlet.class);
    }
}

/*
модуль конфигурации веб сущностей (сервлетовб фильтров и т.д.)
предоставляется 3й вариант регистрации фильтров и сервлетов.
Для него необходимо добавить для всех классов фильтров и сервлетов аннотацию
а также снимаем другие формы регистрации (анотации или web.xml)
 */