/*
 *  guice - tech.majava.guice.ConfigProvider
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

import com.google.inject.Provider;
import lombok.SneakyThrows;
import org.reflections.Reflections;
import tech.majava.context.config.ApplicationConfig;
import tech.majava.context.config.Config;
import tech.majava.context.config.Methods;
import tech.majava.modules.Module;
import tech.majava.utils.LambaUtils;

import javax.annotation.Nonnull;

/**
 * <p><b>Class {@link ConfigProvider}</b></p>
 *
 * @author majksa
 * @version 1.0.0
 * @since 1.0.0
 */
public final class ConfigProvider implements Provider<ApplicationConfig> {

    @Override
    @SneakyThrows({NoSuchMethodException.class, SecurityException.class})
    public ApplicationConfig get() {
        final ApplicationConfig main = ApplicationConfig.load();
        if (main.getDi() == null) {
            final Methods methods = new Methods();
            methods.put(GuiceContainer.class.getDeclaredMethod("getContainer"));
            main.setDi(methods);
        }
        final Reflections reflections = new Reflections();
        reflections.getSubTypesOf(Module.class)
                .stream()
                .filter(LambaUtils.negate(main.getModules()::containsValue))
                .forEach(module -> register(module, main));
        return main;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private static void register(@Nonnull Class<? extends Module> module, ApplicationConfig config) {
        String name = parseModuleName(module.getName());
        if (config.getModules().containsKey(name)) {
            name = module.getName();
        }
        config.getModules().put(name, (Class<? extends Module<? extends Config>>) module);
    }

    private static String parseModuleName(String className) {
        final String[] parts = className.split("\\.");
        if (parts.length <= 1) {
            return className;
        }
        return parts[parts.length - 2];
    }

}
