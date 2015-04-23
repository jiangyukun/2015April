package me.jiangyu.april.core.test;

/**
 * Created by jiangyukun on 15/4/21.
 */
public class ObjectCopy implements Cloneable {
    ObjectCopy o1;

    public static void main(String[] args) throws Exception {
        ObjectCopy copy = new ObjectCopy();
        copy.o1 = new ObjectCopy();
        ObjectCopy clone = copy.clone();

        System.out.println(copy.o1);
        System.out.println(clone.o1);

    }

    @Override
    public ObjectCopy clone() throws CloneNotSupportedException {
        ObjectCopy o = (ObjectCopy) super.clone();
        if (o1 != null)
            o.o1 = o1.clone();
        return o;
    }
}
