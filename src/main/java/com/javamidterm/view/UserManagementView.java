package com.javamidterm.view;

import com.javamidterm.model.Student;
import com.javamidterm.model.User;
import com.javamidterm.service.StudentService;
import com.javamidterm.service.UserService;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class UserManagementView extends javax.swing.JFrame {

    UserService userService;
    StudentService studentService;
    DefaultTableModel defaultTableModel;
    DefaultTableModel studentTableModel;
    User updatedUser;
    Student updatedStudent;

    public UserManagementView() throws SQLException, ClassNotFoundException {

        initComponents();
        
        ImageIcon originalIcon = new ImageIcon("src/main/resources/user.jpg");
        ImageIcon resizedIcon = resizeImageIcon(originalIcon, 100, 100);
        avatar.setIcon(resizedIcon);
        
        userService = new UserService();

        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        userTable.setModel(defaultTableModel);

        defaultTableModel.addColumn("Id");
        defaultTableModel.addColumn("Username");
        defaultTableModel.addColumn("Password");
        defaultTableModel.addColumn("Role");
        defaultTableModel.addColumn("Avatar");

        loadData(userService.getAllUsers());

//        ---------------------------------
        studentService = new StudentService();

        studentTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        studentTable.setModel(studentTableModel);

        studentTableModel.addColumn("Id");
        studentTableModel.addColumn("Name");
        studentTableModel.addColumn("Age");
        studentTableModel.addColumn("Phone number");
        studentTableModel.addColumn("Status");

        loadStudentData(studentService.getAllStudent());
    }
    
    private static ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        student = new javax.swing.JPanel();
        listPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        search1 = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        searchBtn1 = new javax.swing.JButton();
        table1 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();
        fromPanel1 = new javax.swing.JPanel();
        userInfoLabel1 = new javax.swing.JLabel();
        userFormPanel1 = new javax.swing.JPanel();
        ageField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        phoneField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        btns1 = new javax.swing.JPanel();
        addStudentBtn = new javax.swing.JButton();
        updateStudentBtn = new javax.swing.JButton();
        deleteStudentBtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        normalStatus = new javax.swing.JRadioButton();
        lockedStatus = new javax.swing.JRadioButton();
        user = new javax.swing.JPanel();
        listPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        search = new javax.swing.JPanel();
        userSearchField = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        table = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        fromPanel = new javax.swing.JPanel();
        userInfoLabel = new javax.swing.JLabel();
        userFormPanel = new javax.swing.JPanel();
        passwordField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        avatarField = new javax.swing.JTextField();
        usernameField = new javax.swing.JTextField();
        adminRole = new javax.swing.JRadioButton();
        managerRole = new javax.swing.JRadioButton();
        employeeRole = new javax.swing.JRadioButton();
        avatar = new javax.swing.JLabel();
        btns = new javax.swing.JPanel();
        addUserBtn = new javax.swing.JButton();
        updateUserBtn = new javax.swing.JButton();
        deleteUserBtn = new javax.swing.JButton();
        clearFormBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UserManagementView");
        setMinimumSize(new java.awt.Dimension(400, 300));
        setName("300"); // NOI18N

        jLabel1.setBackground(new java.awt.Color(204, 255, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Student Management System");

        student.setBackground(new java.awt.Color(196, 248, 246));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Student List");

        searchField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

        searchBtn1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchBtn1.setText("Search");
        searchBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout search1Layout = new javax.swing.GroupLayout(search1);
        search1.setLayout(search1Layout);
        search1Layout.setHorizontalGroup(
            search1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(search1Layout.createSequentialGroup()
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addGap(35, 35, 35))
        );
        search1Layout.setVerticalGroup(
            search1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, search1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(search1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn1))
                .addGap(37, 37, 37))
        );

        studentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        studentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentTableMouseClicked(evt);
            }
        });
        table1.setViewportView(studentTable);

        javax.swing.GroupLayout listPanel1Layout = new javax.swing.GroupLayout(listPanel1);
        listPanel1.setLayout(listPanel1Layout);
        listPanel1Layout.setHorizontalGroup(
            listPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(search1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(table1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        listPanel1Layout.setVerticalGroup(
            listPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(search1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(table1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        userInfoLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        userInfoLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userInfoLabel1.setText("Student Information Form");

        ageField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ageField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageFieldActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Status");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Age");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Name");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Phone");

        phoneField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        nameField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btns1.setLayout(new java.awt.GridLayout(1, 0, 4, 0));

        addStudentBtn.setBackground(new java.awt.Color(51, 255, 51));
        addStudentBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addStudentBtn.setForeground(new java.awt.Color(246, 246, 246));
        addStudentBtn.setText("Add new");
        addStudentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentBtnActionPerformed(evt);
            }
        });
        btns1.add(addStudentBtn);

        updateStudentBtn.setBackground(new java.awt.Color(255, 204, 51));
        updateStudentBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        updateStudentBtn.setForeground(new java.awt.Color(246, 246, 246));
        updateStudentBtn.setText("Update");
        updateStudentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateStudentBtnActionPerformed(evt);
            }
        });
        btns1.add(updateStudentBtn);

        deleteStudentBtn.setBackground(new java.awt.Color(255, 0, 0));
        deleteStudentBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteStudentBtn.setForeground(new java.awt.Color(246, 246, 246));
        deleteStudentBtn.setText("Delete");
        deleteStudentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteStudentBtnActionPerformed(evt);
            }
        });
        btns1.add(deleteStudentBtn);

        jButton2.setBackground(new java.awt.Color(51, 255, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(246, 246, 246));
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        btns1.add(jButton2);

        buttonGroup2.add(normalStatus);
        normalStatus.setText("Normal");

        buttonGroup2.add(lockedStatus);
        lockedStatus.setText("Locked");

        javax.swing.GroupLayout userFormPanel1Layout = new javax.swing.GroupLayout(userFormPanel1);
        userFormPanel1.setLayout(userFormPanel1Layout);
        userFormPanel1Layout.setHorizontalGroup(
            userFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userFormPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userFormPanel1Layout.createSequentialGroup()
                        .addGroup(userFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(userFormPanel1Layout.createSequentialGroup()
                                .addGroup(userFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(userFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(phoneField)
                                    .addGroup(userFormPanel1Layout.createSequentialGroup()
                                        .addComponent(normalStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lockedStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(userFormPanel1Layout.createSequentialGroup()
                                .addGroup(userFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(39, 39, 39)
                                .addGroup(userFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ageField)
                                    .addComponent(nameField))))
                        .addGap(25, 25, 25))
                    .addGroup(userFormPanel1Layout.createSequentialGroup()
                        .addComponent(btns1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        userFormPanel1Layout.setVerticalGroup(
            userFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userFormPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(userFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(ageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(userFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(userFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(normalStatus)
                    .addComponent(lockedStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btns1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout fromPanel1Layout = new javax.swing.GroupLayout(fromPanel1);
        fromPanel1.setLayout(fromPanel1Layout);
        fromPanel1Layout.setHorizontalGroup(
            fromPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fromPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fromPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fromPanel1Layout.createSequentialGroup()
                        .addComponent(userInfoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fromPanel1Layout.createSequentialGroup()
                        .addComponent(userFormPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        fromPanel1Layout.setVerticalGroup(
            fromPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fromPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userInfoLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userFormPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        javax.swing.GroupLayout studentLayout = new javax.swing.GroupLayout(student);
        student.setLayout(studentLayout);
        studentLayout.setHorizontalGroup(
            studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(fromPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        studentLayout.setVerticalGroup(
            studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fromPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Student", student);

        user.setBackground(new java.awt.Color(201, 246, 248));
        user.setMinimumSize(new java.awt.Dimension(400, 400));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("User List");

        userSearchField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        userSearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userSearchFieldActionPerformed(evt);
            }
        });

        searchBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchLayout = new javax.swing.GroupLayout(search);
        search.setLayout(searchLayout);
        searchLayout.setHorizontalGroup(
            searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchLayout.createSequentialGroup()
                .addComponent(userSearchField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        searchLayout.setVerticalGroup(
            searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn))
                .addGap(37, 37, 37))
        );

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        userTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTableMouseClicked(evt);
            }
        });
        table.setViewportView(userTable);

        javax.swing.GroupLayout listPanelLayout = new javax.swing.GroupLayout(listPanel);
        listPanel.setLayout(listPanelLayout);
        listPanelLayout.setHorizontalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(search, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(table, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE))
                .addContainerGap())
        );
        listPanelLayout.setVerticalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        userInfoLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        userInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userInfoLabel.setText("User Information");

        passwordField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Avatar");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Password");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Username");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Role");

        avatarField.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        avatarField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                avatarFieldMouseClicked(evt);
            }
        });
        avatarField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avatarFieldActionPerformed(evt);
            }
        });

        usernameField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        buttonGroup1.add(adminRole);
        adminRole.setText("Admin");

        buttonGroup1.add(managerRole);
        managerRole.setText("Manager");

        buttonGroup1.add(employeeRole);
        employeeRole.setText("Employee");

        javax.swing.GroupLayout userFormPanelLayout = new javax.swing.GroupLayout(userFormPanel);
        userFormPanel.setLayout(userFormPanelLayout);
        userFormPanelLayout.setHorizontalGroup(
            userFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, userFormPanelLayout.createSequentialGroup()
                        .addGroup(userFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(userFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordField)
                            .addComponent(usernameField)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, userFormPanelLayout.createSequentialGroup()
                        .addGroup(userFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(userFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(avatarField)
                            .addGroup(userFormPanelLayout.createSequentialGroup()
                                .addComponent(adminRole, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(managerRole, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(employeeRole, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(25, 25, 25))
            .addGroup(userFormPanelLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        userFormPanelLayout.setVerticalGroup(
            userFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(userFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(userFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(adminRole)
                    .addComponent(managerRole)
                    .addComponent(employeeRole))
                .addGap(37, 37, 37)
                .addGroup(userFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(avatarField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(avatar, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
        );

        btns.setLayout(new java.awt.GridLayout(1, 0, 4, 0));

        addUserBtn.setBackground(new java.awt.Color(51, 255, 51));
        addUserBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addUserBtn.setForeground(new java.awt.Color(246, 246, 246));
        addUserBtn.setText("Add new");
        addUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserBtnActionPerformed(evt);
            }
        });
        btns.add(addUserBtn);

        updateUserBtn.setBackground(new java.awt.Color(255, 204, 51));
        updateUserBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        updateUserBtn.setForeground(new java.awt.Color(246, 246, 246));
        updateUserBtn.setText("Update");
        updateUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateUserBtnActionPerformed(evt);
            }
        });
        btns.add(updateUserBtn);

        deleteUserBtn.setBackground(new java.awt.Color(255, 0, 0));
        deleteUserBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteUserBtn.setForeground(new java.awt.Color(246, 246, 246));
        deleteUserBtn.setText("Delete");
        deleteUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserBtnActionPerformed(evt);
            }
        });
        btns.add(deleteUserBtn);

        clearFormBtn.setBackground(new java.awt.Color(51, 255, 255));
        clearFormBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        clearFormBtn.setForeground(new java.awt.Color(246, 246, 246));
        clearFormBtn.setText("Clear");
        clearFormBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearFormBtnActionPerformed(evt);
            }
        });
        btns.add(clearFormBtn);

        javax.swing.GroupLayout fromPanelLayout = new javax.swing.GroupLayout(fromPanel);
        fromPanel.setLayout(fromPanelLayout);
        fromPanelLayout.setHorizontalGroup(
            fromPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fromPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fromPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fromPanelLayout.createSequentialGroup()
                        .addComponent(userInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fromPanelLayout.createSequentialGroup()
                        .addComponent(userFormPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(fromPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btns, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        fromPanelLayout.setVerticalGroup(
            fromPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fromPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userInfoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userFormPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout userLayout = new javax.swing.GroupLayout(user);
        user.setLayout(userLayout);
        userLayout.setHorizontalGroup(
            userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(fromPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        userLayout.setVerticalGroup(
            userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userLayout.createSequentialGroup()
                        .addComponent(listPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 71, Short.MAX_VALUE))
                    .addComponent(fromPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("User", user);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadData(List<User> users) {
        for (User u : users) {
            defaultTableModel.addRow(new Object[]{u.getUserId(), u.getUsername(), u.getPassword(), u.getRole(), u.getProfilePicture()});
        }
    }

    private void loadStudentData(List<Student> students) {
        for (Student s : students) {
            studentTableModel.addRow(new Object[]{s.getStudentId(), s.getName(), s.getAge(), s.getPhoneNumber(), s.getStatus()});
        }
    }

    private void updateUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateUserBtnActionPerformed
        // TODO add your handling code here:
        updatedUser.setUsername(usernameField.getText());
        updatedUser.setPassword(passwordField.getText());
        String role = "";
        if (adminRole.isSelected()) {
            role = "ADMIN";
        } else if (managerRole.isSelected()) {
            role = "MANAGER";
        } else if (employeeRole.isSelected()) {
            role = "EMPLOYEE";
        }
        updatedUser.setRole(role);
        updatedUser.setProfilePicture(avatarField.getText());
        if (validateInput(usernameField.getText(), passwordField.getText(), role, avatarField.getText())) {
            userService.updateUser(updatedUser);
            JOptionPane.showMessageDialog(UserManagementView.this, "Update user info successfully");
            clearStudentForm();
            defaultTableModel.setRowCount(0);
            loadData(userService.getAllUsers());
        }
    }//GEN-LAST:event_updateUserBtnActionPerformed

    private void addUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserBtnActionPerformed
        String username = usernameField.getText();
        String password = passwordField.getText();
//        ----------------
        String role = "";
        if (adminRole.isSelected()) {
            role = "ADMIN";
        } else if (managerRole.isSelected()) {
            role = "MANAGER";
        } else if (employeeRole.isSelected()) {
            role = "EMPLOYEE";
        }

        String avatarPath = avatarField.getText();
        String[] pathElements = avatarPath.split("\\\\");
        String fileName = pathElements[pathElements.length - 1];
        String srcPath = "src/main/resources/" + fileName;
        if (validateInput(username, password, role, avatarPath)) {
            try {
                Path sourcePath = Path.of(avatarPath);
                Path destinationPath = Path.of("src/main/resources", sourcePath.getFileName().toString());
                System.out.println(destinationPath);
                Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                User newUser = new User(username, password, role, srcPath);

                userService.addUser(newUser);
                JOptionPane.showMessageDialog(UserManagementView.this, "Add new user successfully");
                clear();
                defaultTableModel.setRowCount(0);
                loadData(userService.getAllUsers());

            } catch (IOException ex) {
            }
        }
    }//GEN-LAST:event_addUserBtnActionPerformed

    private void userSearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userSearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userSearchFieldActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked

    }//GEN-LAST:event_jLabel5MouseClicked

    private void deleteUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUserBtnActionPerformed
        // TODO add your handling code here:
        int row = userTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(UserManagementView.this, "Please choose a row you want to delete!", "Delete Student", JOptionPane.ERROR_MESSAGE);
        } else {
            int confirm = JOptionPane.showConfirmDialog(UserManagementView.this, "Are you sure ?", "Confirm delete", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                int id = Integer.parseInt(String.valueOf(userTable.getValueAt(row, 0)));
                userService.deleteUser(id);
                defaultTableModel.setRowCount(0);
                loadData(userService.getAllUsers());
            }
        }
    }//GEN-LAST:event_deleteUserBtnActionPerformed

    private void avatarFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avatarFieldActionPerformed

    }//GEN-LAST:event_avatarFieldActionPerformed

    private void avatarFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_avatarFieldMouseClicked
        // TODO add your handling code here:
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg", "png");
        file.addChoosableFileFilter(filter);
        int output = file.showSaveDialog(file);
        if (output == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();

            avatarField.setText(path);
        }
    }//GEN-LAST:event_avatarFieldMouseClicked

    private void clearFormBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFormBtnActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_clearFormBtnActionPerformed

    private void userTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTableMouseClicked
        // TODO add your handling code here:
        int row = userTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(UserManagementView.this, "Please choose a row you want to update!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int id = Integer.parseInt(String.valueOf(userTable.getValueAt(row, 0)));
            updatedUser = userService.getUserById(id);
            updatedUser.setUserId(id);
            usernameField.setText(updatedUser.getUsername());
            passwordField.setText(updatedUser.getPassword());
            if (updatedUser.getRole().equals("ADMIN")) {
                adminRole.setSelected(true);
            } else if (updatedUser.getRole().equals("MANAGER")) {
                managerRole.setSelected(true);
            }
            if (updatedUser.getRole().equals("EMPLOYEE")) {
                employeeRole.setSelected(true);
            }
            avatarField.setText(updatedUser.getProfilePicture());
            ImageIcon originalIcon = new ImageIcon(updatedUser.getProfilePicture());
            ImageIcon resizedIcon = resizeImageIcon(originalIcon, 100, 100);
            avatar.setIcon(resizedIcon);
        }
    }//GEN-LAST:event_userTableMouseClicked

    private void updateStudentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateStudentBtnActionPerformed
        // TODO add your handling code here:
        updatedStudent.setName(nameField.getText());
        updatedStudent.setAge(Integer.parseInt(ageField.getText()));
        updatedStudent.setPhoneNumber(phoneField.getText());
        String status = "";
        if (normalStatus.isSelected()) {
            status = "normal";
        } else if (lockedStatus.isSelected()) {
            status = "locked";
        }
        updatedStudent.setStatus(status);
        if (validateStudentInput(nameField.getText(), ageField.getText(), phoneField.getText(), status)) {
            studentService.updateStudent(updatedStudent);
            clear();
            JOptionPane.showMessageDialog(UserManagementView.this, "update student infor successfully");
            studentTableModel.setRowCount(0);
            try {
                loadStudentData(studentService.getAllStudent());
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(UserManagementView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_updateStudentBtnActionPerformed

    private void addStudentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentBtnActionPerformed
        // TODO add your handling code here:
        Student newStudent = new Student();
        newStudent.setName(nameField.getText());
        newStudent.setAge(Integer.parseInt(ageField.getText()));
        newStudent.setPhoneNumber(phoneField.getText());
        String status = "";
        if (normalStatus.isSelected()) {
            status = "normal";
        } else if (lockedStatus.isSelected()) {
            status = "locked";
        }
        newStudent.setStatus(status);
        if (validateStudentInput(nameField.getText(), ageField.getText(), phoneField.getText(), status)) {
            studentService.addStudent(newStudent);
            clearStudentForm();
            JOptionPane.showMessageDialog(UserManagementView.this, "Add new student successfully");
            studentTableModel.setRowCount(0);
            try {
                loadStudentData(studentService.getAllStudent());
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(UserManagementView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_addStudentBtnActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseClicked

    private void studentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentTableMouseClicked

        int row = studentTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(UserManagementView.this, "Please choose a row you want to update!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int id = Integer.parseInt(String.valueOf(studentTable.getValueAt(row, 0)));
            updatedStudent = studentService.getStudentById(id);
            updatedStudent.setStudentId(id);
            nameField.setText(updatedStudent.getName());
            ageField.setText(String.valueOf(updatedStudent.getAge()));
            phoneField.setText(updatedStudent.getPhoneNumber());
            if (updatedStudent.getStatus().equals("normal")) {
                normalStatus.setSelected(true);
            } else if (updatedStudent.getStatus().equals("locked")) {
                lockedStatus.setSelected(true);
            }
        }
    }//GEN-LAST:event_studentTableMouseClicked

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        clearStudentForm();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void deleteStudentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteStudentBtnActionPerformed
        // TODO add your handling code here:
        int row = studentTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(UserManagementView.this, "Please choose a row you want to delete!", "Delete Student", JOptionPane.ERROR_MESSAGE);
        } else {
            int confirm = JOptionPane.showConfirmDialog(UserManagementView.this, "Are you sure ?", "Confirm delete", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                int id = Integer.parseInt(String.valueOf(studentTable.getValueAt(row, 0)));
                try {
                    studentService.deleteStudent(id);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UserManagementView.class.getName()).log(Level.SEVERE, null, ex);
                }

                studentTableModel.setRowCount(0);
                try {
                    loadStudentData(studentService.getAllStudent());
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(UserManagementView.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }//GEN-LAST:event_deleteStudentBtnActionPerformed

    private void ageFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageFieldActionPerformed

    private void searchBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtn1ActionPerformed
        
        studentTableModel.setRowCount(0);

        String query = searchField.getText();
        try {
            for (Student s : studentService.getAllStudent()) {
                if (s.getName().toLowerCase().contains(query.toLowerCase())
                        || String.valueOf(s.getAge()).contains(query)
                        || s.getPhoneNumber().contains(query) || s.getStatus().toLowerCase().contains(query)) {
                    studentTableModel.addRow(new Object[]{s.getStudentId(), s.getName(), s.getAge(), s.getPhoneNumber(), s.getStatus()});
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserManagementView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_searchBtn1ActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
        defaultTableModel.setRowCount(0);
        String query = userSearchField.getText();
        for (User u : userService.getAllUsers()) {
            if (u.getUsername().toLowerCase().contains(query.toLowerCase())
                    || String.valueOf(u.getPassword()).contains(query)
                    || u.getRole().contains(query.toUpperCase())) {
                defaultTableModel.addRow(new Object[]{u.getUserId(), u.getUsername(), u.getPassword(), u.getRole(), u.getProfilePicture()});
            }
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void clear() {
        usernameField.setText("");
        passwordField.setText("");
        buttonGroup1.clearSelection();
        avatarField.setText("");
    }

    private void clearStudentForm() {
        nameField.setText("");
        ageField.setText("");
        buttonGroup2.clearSelection();
        phoneField.setText("");
    }

    private boolean validateInput(String username, String password, String role, String filePath) {
        // Add your validation logic here
        if (username.isEmpty() || password.isEmpty() || filePath.isEmpty() || role.isEmpty()) {
            JOptionPane.showMessageDialog(UserManagementView.this, "Please complete all the field!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (password.length() < 6) {
            JOptionPane.showMessageDialog(UserManagementView.this, "The password must has the length greater than 6!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean validateStudentInput(String name, String age, String phone, String status) {
        if (name.isEmpty() || phone.isEmpty() || status.isEmpty()) {
            JOptionPane.showMessageDialog(UserManagementView.this, "Please complete all the field!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!checkIsStringNumber(age)) {
            JOptionPane.showMessageDialog(UserManagementView.this, "The age is not valid", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (phone.length() < 10 || !checkIsStringNumber(phone)) {
            JOptionPane.showMessageDialog(UserManagementView.this, "The phone number is not valid!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;

    }

    public static boolean checkIsStringNumber(String input) {
        String phonePattern = "^[+]?[0-9\\-\\s.()]+";

        // Additional checks based on your requirements can be added here
        return input != null && input.matches(phonePattern);
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            try {
                new UserManagementView().setVisible(true);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(UserManagementView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addStudentBtn;
    private javax.swing.JButton addUserBtn;
    private javax.swing.JRadioButton adminRole;
    private javax.swing.JTextField ageField;
    private javax.swing.JLabel avatar;
    private javax.swing.JTextField avatarField;
    private javax.swing.JPanel btns;
    private javax.swing.JPanel btns1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton clearFormBtn;
    private javax.swing.JButton deleteStudentBtn;
    private javax.swing.JButton deleteUserBtn;
    private javax.swing.JRadioButton employeeRole;
    private javax.swing.JPanel fromPanel;
    private javax.swing.JPanel fromPanel1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel listPanel;
    private javax.swing.JPanel listPanel1;
    private javax.swing.JRadioButton lockedStatus;
    private javax.swing.JRadioButton managerRole;
    private javax.swing.JTextField nameField;
    private javax.swing.JRadioButton normalStatus;
    private javax.swing.JTextField passwordField;
    private javax.swing.JTextField phoneField;
    private javax.swing.JPanel search;
    private javax.swing.JPanel search1;
    private javax.swing.JButton searchBtn;
    private javax.swing.JButton searchBtn1;
    private javax.swing.JTextField searchField;
    private javax.swing.JPanel student;
    private javax.swing.JTable studentTable;
    private javax.swing.JScrollPane table;
    private javax.swing.JScrollPane table1;
    private javax.swing.JButton updateStudentBtn;
    private javax.swing.JButton updateUserBtn;
    private javax.swing.JPanel user;
    private javax.swing.JPanel userFormPanel;
    private javax.swing.JPanel userFormPanel1;
    private javax.swing.JLabel userInfoLabel;
    private javax.swing.JLabel userInfoLabel1;
    private javax.swing.JTextField userSearchField;
    private javax.swing.JTable userTable;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
