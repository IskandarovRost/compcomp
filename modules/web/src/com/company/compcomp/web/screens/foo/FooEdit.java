package com.company.compcomp.web.screens.foo;

import com.haulmont.cuba.gui.screen.*;
import com.company.compcomp.entity.Foo;

@UiController("compcomp_Foo.edit")
@UiDescriptor("foo-edit.xml")
@EditedEntityContainer("fooDc")
@LoadDataBeforeShow
public class FooEdit extends StandardEditor<Foo> {
}