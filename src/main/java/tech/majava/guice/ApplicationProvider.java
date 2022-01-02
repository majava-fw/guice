/*
 *  guice - tech.majava.guice.ApplicationProvider
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

import com.google.inject.Inject;
import com.google.inject.Provider;
import lombok.RequiredArgsConstructor;
import tech.majava.application.Application;
import tech.majava.context.ApplicationContext;

/**
 * <p><b>Class {@link ApplicationProvider}</b></p>
 *
 * @author majksa
 * @version 1.0.0
 * @since 1.0.0
 */
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public final class ApplicationProvider implements Provider<Application> {

    private final ApplicationContext context;

    @Override
    public Application get() {
        return new Application(context.getName(), context, context.getModules());
    }

}
