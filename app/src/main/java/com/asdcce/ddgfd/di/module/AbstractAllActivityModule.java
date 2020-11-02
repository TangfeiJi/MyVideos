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

import com.asdcce.ddgfd.di.component.BaseActivityComponent;
import com.asdcce.ddgfd.modules.login.ui.activity.LoginActivity;
import com.asdcce.ddgfd.modules.login.ui.activity.PersonInforActivity;
import com.asdcce.ddgfd.modules.main.ui.MainActivity;
import com.asdcce.ddgfd.modules.main.ui.activity.HtmlActivity;
import com.asdcce.ddgfd.modules.mine.ui.AboutActivity;
import com.asdcce.ddgfd.modules.mine.ui.VersionActivity;
import com.asdcce.ddgfd.modules.mine.ui.InforEditActivity;
import com.asdcce.ddgfd.modules.recycle.ui.activity.RecycleActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(subcomponents = {BaseActivityComponent.class})
public abstract class AbstractAllActivityModule {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity contributesMainActivityInjector();


    @ContributesAndroidInjector(modules = VersionActivityModule.class)
    abstract VersionActivity contributesVersionActivityInject();


    @ContributesAndroidInjector(modules = AboutActivityModule.class)
    abstract AboutActivity contributesAboutActivityInject();



    @ContributesAndroidInjector(modules = HtmlActivityModule.class)
    abstract HtmlActivity HtmlActivityInject();


    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity LoginActivityActivityInject();



    @ContributesAndroidInjector(modules = InforEditActivityModule.class)
    abstract InforEditActivity InforEditActivityInject();


    @ContributesAndroidInjector(modules = RecycleActivityModule.class)
    abstract RecycleActivity RecycleActivityInject();



    @ContributesAndroidInjector(modules = PersonInforActivityModule.class)
    abstract PersonInforActivity PersonInforActivityInject();



}
