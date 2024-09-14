package itstep.learning.ioc;

import com.google.inject.AbstractModule;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import itstep.learning.Services.hash.HashService;
import itstep.learning.Services.hash.ShaHashService;
import itstep.learning.Services.hash.md5HashService;

public class ServiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(HashService.class)
                .annotatedWith(Names.named("digest"))
                .to(md5HashService.class);
        bind(HashService.class)
                .annotatedWith(Names.named("signature"))
                .to(ShaHashService.class);
        bind(String.class)
                .annotatedWith(Names.named("viewsFolder"))
                .toInstance("views");
        bind(String.class)
                .annotatedWith(Names.named("resourceFolder"))
                .toInstance("resource");
    }
}

/*
модуль регистрации сервисов-служб  универсального типа, не только веб-назначения
 */