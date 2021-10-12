package com.krasnov.example.aop_practice.aspect;

/**
 * List AppException catch blocks and callers as a way
 * of investigating a possibly-large code base.
 */
aspect AspectJ {
    pointcut withinScope() : within(com.company..*);

    /*
     * Find calls to stuff that throws AppException.
     */
    declare warning : withinScope() &&
            (call(* *(..) throws RuntimeException+)
                    || call(new(..) throws RuntimeException+)) :
            "fyi, another call to something that can throw IOException";

    /*
     * Find catch clauses handling AppException
     */
    declare warning : withinScope() && handler(AppException+):
            "fyi, code that handles AppException";
}

