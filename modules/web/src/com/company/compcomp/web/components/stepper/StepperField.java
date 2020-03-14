package com.company.compcomp.web.components.stepper;

import com.haulmont.bali.events.Subscription;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.data.ValueSource;
import com.haulmont.cuba.web.gui.components.*;

import java.util.Collection;
import java.util.function.Consumer;

@CompositeDescriptor("stepper-component.xml")
public class StepperField
        extends CompositeComponent<HBoxLayout>
        implements Field<Integer>,
        CompositeWithCaption,
        CompositeWithHtmlCaption,
        CompositeWithHtmlDescription,
        CompositeWithIcon,
        CompositeWithContextHelp {

    public static final String NAME = "stepperField";

    private TextField<Integer> valueField;
    private Button upBtn;
    private Button downBtn;

    private int step = 1;

    boolean htmlSanEnabled;

    @Override
    public boolean isHtmlSanitizerEnabled() {
        return false;
    }

    @Override
    public void setHtmlSanitizerEnabled(boolean htmlSanitizerEnabled) {
        this.htmlSanEnabled = htmlSanitizerEnabled;
    }

    public StepperField() {
        addCreateListener(this::onCreate);
    }

    private void onCreate(CreateEvent createEvent) {
        valueField = getInnerComponent("valueField");
        upBtn = getInnerComponent("upBtn");
        downBtn = getInnerComponent("downBtn");

        upBtn.addClickListener(clickEvent -> updateValue(step));
        downBtn.addClickListener(clickEvent -> updateValue(-step));
    }

    private void updateValue(int delta) {
        Integer value = getValue();
        setValue(value != null ? value + delta : delta);
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    @Override
    public boolean isRequired() {
        return valueField.isRequired();
    }

    @Override
    public void setRequired(boolean required) {
        valueField.setRequired(required);
        getComposition().setRequiredIndicatorVisible(required);
    }

    @Override
    public String getRequiredMessage() {
        return valueField.getRequiredMessage();
    }

    @Override
    public void setRequiredMessage(String msg) {
        valueField.setRequiredMessage(msg);
    }

    @Override
    public void addValidator(Consumer<? super Integer> validator) {
        valueField.addValidator(validator);
    }

    @Override
    public void removeValidator(Consumer<Integer> validator) {
        valueField.removeValidator(validator);
    }

    @Override
    public Collection<Consumer<Integer>> getValidators() {
        return valueField.getValidators();
    }

    @Override
    public boolean isEditable() {
        return valueField.isEditable();
    }

    @Override
    public void setEditable(boolean editable) {
        valueField.setEditable(editable);
        upBtn.setEnabled(editable);
        downBtn.setEnabled(editable);
    }

    @Override
    public Integer getValue() {
        return valueField.getValue();
    }

    @Override
    public void setValue(Integer value) {
        valueField.setValue(value);
    }

    @Override
    public Subscription addValueChangeListener(Consumer<ValueChangeEvent<Integer>> listener) {
        return valueField.addValueChangeListener(listener);
    }

    @Override
    public void removeValueChangeListener(Consumer<ValueChangeEvent<Integer>> listener) {
        valueField.removeValueChangeListener(listener);
    }

    @Override
    public boolean isValid() {
        return valueField.isValid();
    }

    @Override
    public void validate() throws ValidationException {
        valueField.validate();
    }

    @Override
    public void setValueSource(ValueSource<Integer> valueSource) {
        valueField.setValueSource(valueSource);
        getComposition().setRequiredIndicatorVisible(valueField.isRequired());
    }

    @Override
    public ValueSource<Integer> getValueSource() {
        return valueField.getValueSource();
    }
}