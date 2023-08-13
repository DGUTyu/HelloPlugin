package cn.rxjava.action;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.MessageType;

/**
 * 创建一个动作action
 * 参考链接：https://juejin.cn/post/6844904127990857742#heading-6
 * 1.创建action
 * 2.填写相关参数
 * ① action的基本信息，其中Name属性的值作为将来菜单的文本内容
 * ID:test_id  Class Name:TestAction  Name:通知  Description:测试通知的功能
 * ② 作为Tools菜单下的子菜单
 * ③ 子菜单位置放在第一个
 * ④ 为子菜单添加快捷键
 * 3.编写点击菜单的通知内容
 */
public class TestAction extends AnAction {

    /**
     * 创建一个显示为气球状的通知，通知的内容是"测试通知内容"，通知的类型为信息类型。
     * 通知会以弹出气球的形式显示在屏幕上，提醒用户关于某些事件的信息。
     * <p>
     * 需要实现点击事件发生之后的抽象方法
     * "testid"：这是通知组的唯一ID，用于标识不同的通知组。
     * NotificationDisplayType.BALLOON：这表示通知以气球状（Balloon）方式显示。
     * false：这表示通知是否为单例模式，如果设置为true，则通知将不会叠加显示。
     * Notifications.Bus是IntelliJ平台用于处理通知的总线类。
     */
    @Override
    public void actionPerformed(AnActionEvent e) {
        NotificationGroup notificationGroup = new NotificationGroup("testid", NotificationDisplayType.BALLOON, false);
        Notification notification = notificationGroup.createNotification("测试通知内容", MessageType.INFO);
        Notifications.Bus.notify(notification);
    }
}
