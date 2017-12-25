package xmu.crms.service;

import java.math.BigInteger;
import java.util.List;

import xmu.crms.entity.*;
import xmu.crms.exception.*;

/**
 * @author ZhouZhongjun YeHongjie Heqi Aixing
 * @version 2.00
 */

public interface FixGroupService {
    /**
     * 按FixGroupId删除FixGroupMember.
     *
     * @param fixGroupId 固定分组Id
     * @return true删除成功  false删除失败
     * @throws IllegalArgumentException  信息不合法，id格式错误
     * @throws FixGroupNotFoundException 未找到小组
     * @author zhouzhongjun
     */
    Boolean deleteFixGroupMemberByFixGroupId(BigInteger fixGroupId) throws
            IllegalArgumentException, FixGroupNotFoundException;

    /**
     * 将学生加入固定小组.
     * ＜p＞将用户加入指定的固定小组<br>*
     *
     * @param userId  学生的id
     * @param groupId 要加入固定小组的id
     * @return BigInteger 若创建成功返回该条记录的id，失败则返回-1
     * @throws IllegalArgumentException  信息不合法，id格式错误
     * @throws FixGroupNotFoundException 未找到小组
     * @throws UserNotFoundException     不存在该学生
     * @throws InvalidOperationException 待添加学生已经在小组里了
     * @author YeHongjie
     */
    BigInteger insertFixGroupMemberById(BigInteger userId, BigInteger groupId) throws IllegalArgumentException
            , FixGroupNotFoundException, UserNotFoundException, InvalidOperationException;

    /**
     * 查询固定小组成员.
     * ＜p＞按照固定小组id查询该小组的成员<br>*
     *
     * @param groupId 要查询的固定小组id
     * @return List 固定小组成员信息
     * @throws IllegalArgumentException  信息不合法，id格式错误
     * @throws FixGroupNotFoundException 未找到小组
     * @author YeHongjie
     */
    List<User> listFixGroupMemberByGroupId(BigInteger groupId) throws IllegalArgumentException,
            FixGroupNotFoundException;

    /**
     * 按classId查找FixGroup信息.
     *
     * @param classId 班级Id
     * @return null 固定分组列表
     * @throws IllegalArgumentException 信息不合法，id格式错误
     * @author zhouzhongjun
     */
    List<FixGroup> listFixGroupByClassId(BigInteger classId) throws IllegalArgumentException;

    /**
     * 按classId删除FixGroup
     * <p>先根据classId得到所有的FixGroup信息，再根据FixGroupid删除FixGroupMember表的信息，最后再将FixGroup信息删除<br>
     *
     * @param classId 班级Id
     * @return true删除成功  false删除失败
     * @throws IllegalArgumentException 信息不合法，id格式错误
     * @throws ClassNotFoundException   未找到班级
     * @author zhouzhongjun
     * @see FixGroupService #listFixGroupByClassId(BigInteger classId)
     * @see FixGroupService #deleteFixGroupMemberByFixGroupId(BigInteger fixGroupId)
     */
    Boolean deleteFixGroupByClassId(BigInteger classId) throws IllegalArgumentException,
            ClassNotFoundException;

    /**
     * 删除固定小组.
     * ＜p＞按照id删除固定小组<br>*
     *
     * @param groupId 固定小组的id
     * @return state 若删除成功返回true，失败返回false
     * @throws IllegalArgumentException  信息不合法，id格式错误
     * @throws FixGroupNotFoundException 未找到小组
     * @author YeHongjie
     * @see FixGroupService #deleteFixGroupMemberByFixGroupId(BigInteger fixGroupId)
     */
    Boolean deleteFixGroupByGroupId(BigInteger groupId) throws IllegalArgumentException,
            FixGroupNotFoundException;

    /**
     * 修改固定小组.
     * ＜p＞修改固定小组的信息（不包括成员）<br>*
     *
     * @param groupId    小组的id
     * @param fixGroupBO 小组信息
     * @return Boolean 若更新成功返回true，失败返回false
     * @throws IllegalArgumentException  信息不合法，id格式错误
     * @throws FixGroupNotFoundException 未找到小组
     * @author YeHongjie
     */
    Boolean updateFixGroupByGroupId(BigInteger groupId, FixGroup fixGroupBO) throws
            IllegalArgumentException, FixGroupNotFoundException;

    /**
     * 查询固定小组.
     * ＜p＞按照id查询某一固定小组的信息（包括成员）<br>*
     *
     * @param groupId 小组的id
     * @return fixGroupBO 固定小组对象，若未找到相关小组返回空(null)
     * @throws IllegalArgumentException  信息不合法，id格式错误
     * @throws FixGroupNotFoundException 未找到小组
     * @author YeHongjie
     * @see FixGroupService #listFixGroupMemberByGroupId(BigInteger groupId)
     */
    FixGroup getFixGroupByGroupId(BigInteger groupId) throws IllegalArgumentException,
            FixGroupNotFoundException;


    /**
     * 将学生加入小组.
     * ＜p＞将用户加入指定的小组<br>*
     *
     * @param userId  学生的id
     * @param groupId 要加入小组的id
     * @return BigInteger 若创建成功返回该条记录的id，失败则返回-1
     * @throws FixGroupNotFoundException 信息不合法，id格式错误
     * @throws FixGroupNotFoundException 未找到小组
     * @throws UserNotFoundException     不存在该学生
     * @throws InvalidOperationException 待添加学生已经在小组里了
     * @author YeHongjie
     */
    BigInteger insertStudnetIntoGroup(BigInteger userId, BigInteger groupId) throws
            FixGroupNotFoundException, FixGroupNotFoundException, UserNotFoundException,
            InvalidOperationException;

    /**
     * 小组取消话题.
     * <p>小组按小组id取消讨论课的话题的选择<br>
     *
     * @param groupId 小组id
     * @return true or false 返回取消话题是否成功
     * @throws IllegalArgumentException  信息不合法，id格式错误
     * @throws FixGroupNotFoundException 未找到小组
     * @author heqi
     */
    Boolean deleteTopicByGroupId(BigInteger groupId) throws IllegalArgumentException,
            FixGroupNotFoundException;

    /**
     * 按id获取小组.
     * <p>通过学生id和班级id获取学生所在的班级固定小组<br>
     *
     * @param userId  学生id
     * @param classId 班级id
     * @return GroupBO 返回班级固定小组的信息
     * @throws IllegalArgumentException 信息不合法，id格式错误
     * @throws ClassNotFoundException   未找到小组
     * @throws UserNotFoundException    不存在该学生
     * @author heqi
     * @see UserService#getUserByUserId(BigInteger UserId)
     */
    FixGroup getFixedGroupById(BigInteger userId, BigInteger classId) throws
            IllegalArgumentException, ClassNotFoundException, UserNotFoundException;

    /**
     * 根据groupId修改group.
     * <p>根据groupId修改group<br>
     *
     * @param groupId 要修改的group的Id
     * @param group   新的group信息
     * @return Boolean 若更新成功返回true，失败返回false
     * @throws IllegalArgumentException  信息不合法，id格式错误
     * @throws FixGroupNotFoundException 未找到小组
     * @author aixing
     */
    Boolean updateSeminarGroupById(BigInteger groupId, SeminarGroup group) throws
            IllegalArgumentException, FixGroupNotFoundException;
}
