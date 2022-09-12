package org.example;

public enum Formats {
    first("\\d{4}/[01]\\d/[0-3]\\d"),
    second("[0-3]\\d/[01]\\d/\\d{4}"),
    third("[01]\\d-[0-3]\\d-\\d{4}");

    private final String form;
    Formats(String form){
        this.form=form;
    }
    @Override
    public String toString () {
        return String.valueOf(form);
    }
}
