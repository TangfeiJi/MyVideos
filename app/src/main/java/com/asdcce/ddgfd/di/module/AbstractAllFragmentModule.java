/*
 *     (C) Copyright 2019, FlySky.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.asdcce.ddgfd.di.module;

import com.asdcce.ddgfd.di.component.BaseFragmentComponent;
import com.asdcce.ddgfd.modules.home.ui.HomeFragment;
import com.asdcce.ddgfd.modules.home.ui.HomeNearbyFragment;
import com.asdcce.ddgfd.modules.home.ui.HomeRecomFragment;
import com.asdcce.ddgfd.modules.location.ui.VideoFragment;

import com.asdcce.ddgfd.modules.message.ui.MessageFragment;
import com.asdcce.ddgfd.modules.mine.ui.MineFragment;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(subcomponents = BaseFragmentComponent.class)
public abstract class AbstractAllFragmentModule {


    @ContributesAndroidInjector(modules = LoanFragmentModule.class)
    abstract HomeFragment contributesLoanFragmentInject();

    @ContributesAndroidInjector(modules = HomeFragmentModule.class)
    abstract VideoFragment contributesHomeFragmentInject();

    @ContributesAndroidInjector(modules = MineFragmentModule.class)
    abstract MineFragment contributesMineFragmentInject();

    @ContributesAndroidInjector(modules = MessageFragmentModule.class)
    abstract MessageFragment contributesMessageFragmentInject();


    @ContributesAndroidInjector(modules = HomeRecomFragmentModule.class)
    abstract HomeRecomFragment contributesHomeRecomFragmentInject();

    @ContributesAndroidInjector(modules = HomeNearbyFragmentModule.class)
    abstract HomeNearbyFragment contributesHomeNearbyFragmentInject();
}
