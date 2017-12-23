package xmu.crms.service;

import java.math.BigInteger;
import java.util.List;

import xmu.crms.entity.*;
import xmu.crms.exception.*;

/**
 * @author YeHongjie
 * @version 2.00
 */
public interface UserService {

    /**
     * insert attendant
     *
     * @param classId 班级id
     * @param seminarId a
     * @param userId a
     * @param longitude a
     * @param latitude a
     * @throws IllegalArgumentException a
     * @throws ClassesNotFoundException a
     * @throws SeminarNotFoundException a
     * @author a
     */
    void insertAttendanceById(BigInteger classId, BigInteger seminarId,
                              BigInteger userId, double longitude, double latitude) throws
            IllegalArgumentException, ClassesNotFoundException, SeminarNotFoundException;

    /**
     * 获取学生签到信息.
     * <p>根据班级id，讨论课id获取当堂课签到信息<br>
     *
     * @param classId   班级的id
     * @param seminarId 讨论课id
     * @return list 当堂课签到信息
     * @throws IllegalArgumentException 信息不合法，id格式错误
     * @throws ClassesNotFoundException 未找到班级
     * @throws SeminarNotFoundException 未找到讨论课
     * @author LiuAiqi
     */
    List<Attendance> listAttendanceById(BigInteger classId, BigInteger seminarId)
            throws IllegalArgumentException, ClassesNotFoundException,
            SeminarNotFoundException;

    /**
     * 手机号注册.
     * <p>手机号注册 (.Net使用),User中只有phone和password，userId是注册后才有并且在数据库自增<br>
     *
     * @param user 用户信息(手机号Phone和密码Password)
     * @return user 该用户信息
     * @author qinlingyun
     */
    User signUpPhone(User user);


    /**
     * 用户解绑.
     * <p>教师解绑账号(j2ee使用)<br>
     *
     * @param userId 用户id
     * @throws IllegalArgumentException 信息不合法，id格式错误
     * @throws UserNotFoundException    未找到对应用户
     * @author qinlingyun
     * @see CourseService#listCourseByUserId(BigInteger userId)
     * @see CourseService#deleteCourseByCourseId(BigInteger courseId)
     */
    void deleteTeacherAccount(BigInteger userId) throws IllegalArgumentException,
            UserNotFoundException;


    /**
     * 用户解绑.
     * <p>学生解绑账号(j2ee使用)<br>
     *
     * @param userId 用户id
     * @throws IllegalArgumentException 信息不合法，id格式错误
     * @throws UserNotFoundException    未找到对应用户
     * @author qinlingyun
     * @see ClassService#deleteCourseSelectionById(BigInteger userId, BigInteger classId)
     */
    void deleteStudentAccount(BigInteger userId) throws IllegalArgumentException,
            UserNotFoundException;


    /**
     * 根据用户Id获取用户的信息.
     * <p>根据用户Id获取用户的信息<br>
     *
     * @param userId 用户Id
     * @return user 用户信息
     * @throws IllegalArgumentException throws when 信息不合法，id格式错误
     * @throws UserNotFoundException    throws when 未找到对应用户
     * @author qinlingyun
     * @see SchoolService#getSchoolBySchoolId(BigInteger schoolId)
     */
    User getUserByUserId(BigInteger userId) throws IllegalArgumentException,
            UserNotFoundException;

    /**
     * 根据用户名获取用户ID.
     * <p>根据用户名获取用户ID<br>
     *
     * @param userName 用户名
     * @return userId 用户ID
     * @throws IllegalArgumentException throws when 信息不合法，id格式错误
     * @throws UserNotFoundException    throws when 未找到对应用户
     * @author qinlingyun
     */
    List<BigInteger> listUserIdByUserName(String userName) throws
            IllegalArgumentException, UserNotFoundException;

    ;

    /**
     * 根据用户ID修改用户信息.
     * <p>根据用户ID修改用户信息<br>
     *
     * @param userId 用户Id
     * @param user   用户信息
     * @throws UserNotFoundException throws when 未找到对应用户
     * @author qinlingyun
     */
    void updateUserByUserId(BigInteger userId, User user) throws
            UserNotFoundException;


    /**
     * 按班级ID、学号开头、姓名开头获取学生列表.
     * <p>按班级ID、学号开头、姓名开头获取学生列表<br>
     *
     * @param classId       班级ID
     * @param numBeginWith  学号开头
     * @param nameBeginWith 姓名开头
     * @return list 用户列表
     * @throws IllegalArgumentException throws when 信息不合法
     * @throws ClassesNotFoundException throws when 未找到对应班级
     * @author qinlingyun
     */
    List<User> listUserByClassId(BigInteger classId, String numBeginWith,
                                 String nameBeginWith) throws IllegalArgumentException,
            ClassesNotFoundException;


    /**
     * 根据用户名获取用户列表.
     * <p>根据用户名获取用户列表<br>
     *
     * @param userName 用户名
     * @return list 用户列表
     * @throws UserNotFoundException throws when 未找到对应用户
     * @author qinlingyun
     */
    List<User> listUserByUserName(String userName) throws UserNotFoundException;


    /**
     * 获取讨论课所在的班级的出勤学生名单.
     * <p>根据ID获取讨论课所在的班级的出勤学生名单<br>
     *
     * @param seminarId 讨论课ID
     * @param classId   班级ID
     * @return list 处于出勤状态的学生的列表
     * @throws IllegalArgumentException throws when 信息不合法，id格式错误
     * @author qinlingyun
     * @see UserService #listAttendanceById(BigInteger, BigInteger)
     * @see UserService #getUserByUserId(BigInteger)
     */
    List<User> listPresentStudent(BigInteger seminarId, BigInteger classId)
            throws IllegalArgumentException;


    /**
     * 获取讨论课所在班级缺勤学生名单.
     * <p>获取讨论课所在班级缺勤学生名单<br>
     *
     * @param seminarId 讨论课ID
     * @param classId   班级ID
     * @return list 处于缺勤状态的学生列表
     * @throws IllegalArgumentException throws when 信息不合法，id格式错误
     * @see UserService #listUserByClassId(BigInteger, String, String)
     * @see UserService #listPresentStudent(BigInteger, BigInteger)
     */
    List<User> listAbsenceStudent(BigInteger seminarId, BigInteger classId) throws
            IllegalArgumentException;

    /**
     * 根据教师名称列出课程名称.
     * <p>根据教师名称列出课程名称<br>
     *
     * @param teacherName 教师名称
     * @return list 课程列表
     * @author yexiaona
     * @see UserService #listUserByUserName(String userName)
     * @see CourseService #listCourseByUserId(BigInteger userId)
     */
    List<Course> listCourseByTeacherName(String teacherName);
}
