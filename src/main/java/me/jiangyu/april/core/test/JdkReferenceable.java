package me.jiangyu.april.core.test;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;

/**
 * Created by jyk on 2015/4/3.
 */
public class JdkReferenceable implements Referenceable {
    @Override
    public Reference getReference() throws NamingException {
        byte b = '1';
        char c = '\u1234';
        return null;

    }



}
