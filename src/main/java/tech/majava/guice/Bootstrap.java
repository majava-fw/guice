/*
 *  guice - tech.majava.guice.Bootstrap
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

import tech.majava.cli.CliApplication;

import javax.annotation.Nonnull;

/**
 * <p><b>Class {@link tech.majava.guice.Bootstrap}</b></p>
 *
 * @author majksa
 * @version 1.0.0
 * @since 1.0.0
 */
public class Bootstrap {

    /**
     * Boots and starts the application with default config file
     *
     * @param args application arguments
     */
    public static void run(@Nonnull String[] args) {
        GuiceContainer
                .getInjector()
                .getInstance(CliApplication.class)
                .run(args);
    }

}
