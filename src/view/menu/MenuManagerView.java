package view.menu;

import models.user.User;

import javax.swing.text.View;

public class MenuManagerView implements IMenuTemplate {
    @Override
    public void showMenuMain() {
        System.out.println("""
                    ===================Welcome to Forum of Institut Poblenou====================
                    1. Register
                    2. Login
                    3. Leave
                    ============================================================================
                    """);
    }

    @Override
    public void showMenuForum(User looggedUser) {
        System.out.printf("""
                       ======================Welcome to Forum %s===============
                       =============================%s=========================
                       1. Access your Admin
                       2. Show All Posts
                       3. Show Posts For Degree
                       4. Show Posts For Subject
                       5. Show Posts For Author(Student or Teacher)
                       6. Search Post
                       7. Back
                       ========================================================
                       """,looggedUser.getName(),looggedUser.getClass().getSimpleName());

    }

    @Override
    public void showMenuProfile() {
        System.out.println("""
                ========================Admin your Profile======================
                1. Create New Post
                2. Shows your Posts
                3. Update your Post
                4. Delete your Post
                5. Back
                ================================================================
                """);
    }
}
