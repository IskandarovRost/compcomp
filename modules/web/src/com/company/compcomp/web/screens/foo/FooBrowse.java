package com.company.compcomp.web.screens.foo;

import com.haulmont.cuba.gui.screen.*;
import com.company.compcomp.entity.Foo;

@UiController("compcomp_Foo.browse")
@UiDescriptor("foo-browse.xml")
@LookupComponent("foosTable")
@LoadDataBeforeShow
public class FooBrowse extends StandardLookup<Foo> {
}