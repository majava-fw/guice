/*
 *  guice - tech.majava.guice.Container
 *  Copyright (C) 2022  Majksa
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package tech.majava.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import lombok.Getter;
import lombok.SneakyThrows;
import org.reflections.Reflections;
import tech.majava.di.Container;

import javax.annotation.Nonnull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p><b>Class {@link tech.majava.guice.GuiceContainer}</b></p>
 *
 * @author majksa
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
public class GuiceContainer implements Container {

    @Getter
    private static final Injector injector = initInjector();
    @Getter
    private static final Container container = new GuiceContainer();

    private static Injector initInjector() {
        return Guice.createInjector(new Reflections()
                .getSubTypesOf(AbstractModule.class)
                .stream()
                .filter(clazz -> Modifier.isFinal(clazz.getModifiers()))
                .map(clazz -> {
                    try {
                        return clazz.getConstructor().newInstance();
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList())
        );
    }

    @Nonnull
    @Override
    @Deprecated
    public <T> T get(@Nonnull String s) throws NullPointerException {
        throw new IllegalStateException("Don't use #get(String) when using Guice framework");
    }

    @Nonnull
    @Override
    @Deprecated
    public <T> T get(@Nonnull Class<T> clazz) throws NullPointerException {
        return injector.getInstance(clazz);
    }

    @Nonnull
    @Override
    @Deprecated
    public Container register(@Nonnull String s, @Nonnull Object o) {
        return this;
    }

    @Override
    @Deprecated
    public Container register(@Nonnull Object object) {
        return this;
    }

}
