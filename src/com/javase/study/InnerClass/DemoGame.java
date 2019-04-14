package com.javase.study.InnerClass;

/**
 * 英雄小游戏
 */
public class DemoGame {
    public static void main(String[] args) {
        Hero hero = new Hero();
        hero.setName( "艾斯德斯" );

        //设置英雄技能
//        hero.setSkill( new SkillImpl() ); 使用单独的实现类方式

        //改为匿名内部类方式
        /*Skill skill = new Skill() {
            @Override
            public void use() {
                System.out.println("Pia~pia~pia");
            }
        };
        hero.setSkill( skill );*/

        //进一步简化，同时使用匿名内部类和匿名对象
        hero.setSkill( new Skill() {
            @Override
            public void use() {
                System.out.println("Biu~pia~Biu~pia");
            }
        } );
        hero.attack();

    }
}
