package com.ericsson.eqinson.usingLambda;

import java.io.IOException;

/**
 * Created by eqinson on 2016/10/1.
 */
@FunctionalInterface
public interface MyFileReader<T, R> {
    R read(T path) throws IOException;
}
