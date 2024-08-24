package itstep.learning.ioc;

import com.google.inject.AbstractModule;
import itstep.learning.Services.hash.HashService;
import itstep.learning.Services.hash.md5HashService;

public class ServiceModule extends AbstractModule {
@Override
    protected void configure() {
    bind (HashService.class).to(md5HashService.class);
    //bind (HashService.class).to(md5HashService.class);
}
}

/*
модуль регистрации сервисов-служб  универсального типа, не только веб-назначения
 */