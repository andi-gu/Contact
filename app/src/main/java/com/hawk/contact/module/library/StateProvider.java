/*
 * Copyright 2014 Chris Banes
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hawk.contact.module.library;

import com.hawk.contact.state.ApplicationState;
import com.hawk.contact.state.UserState;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        library = true,
        includes = UtilProvider.class
)
public class StateProvider {

    @Provides @Singleton
    public ApplicationState provideApplicationState(Bus bus) {
        return new ApplicationState(bus);
    }

    @Provides
    public UserState provideUserState(ApplicationState state) {
        return state;
    }

}
