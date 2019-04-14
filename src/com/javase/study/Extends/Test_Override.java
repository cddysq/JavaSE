package com.javase.study.Extends;

/**
 * 方法重写注意事项：
 * 1.必须保证父类子类之间的名称相同，方法列表也相同。
 *
 * @Override：写在方法前面，用来检测是不是有效正确覆盖重写。 这个注解就算不写，只要满足要求，也是正确的方法覆盖重写。
 * 2.子类方法的返回值必须小于等于父类方法的返回值范围。
 *
 * 3.子类方法权限必须【大于等于】父类方法的权限修饰符。
 * 权限：public > protected > (default)不是关键字 > private
 */
public class Test_Override {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.call();
        phone.send();
        phone.show();
        System.out.println("====================");

        NewPhone newPhone = new NewPhone();
        newPhone.call();
        newPhone.send();
        newPhone.show();
    }
}
