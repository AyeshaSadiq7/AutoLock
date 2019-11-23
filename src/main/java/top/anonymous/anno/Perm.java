package top.anonymous.anno;

public @interface Perm {
    public String ensures() default "";

    public String requires() default  "";
}
