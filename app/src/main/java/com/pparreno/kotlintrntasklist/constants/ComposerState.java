package com.pparreno.kotlintrntasklist.constants;

import androidx.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


public abstract class ComposerState {
    // Describes when the annotation will be discarded
    @Retention(RetentionPolicy.SOURCE)
    // Enumerate valid values for this interface
    @StringDef({COMPOSING_STATE, VIEWING_STATE})
    // Create an interface for validating String types
    public @interface ComposerStateDef {
    }

    // Declare the constants
    public static final String COMPOSING_STATE = "COMPOSING_STATE";
    public static final String VIEWING_STATE = "VIEWING_STATE";
}