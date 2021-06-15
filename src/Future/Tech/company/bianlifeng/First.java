package Future.Tech.company.bianlifeng;

/**
 *
 * 一、
 * 给定一组词组，每个词组包含id和字符串的映射，现输入另一组词组，要求找出新的词组与老的词组的diff关系，diff要求如下：
 *         1、id相同且字符串相同的两个词组视为相同
 *         2、id相同，且字符串不同的输出modify+id
 *         3、新的词组id在老的词组id中不存在的，视为新增，输出add+id
 *         4、老的词组id在新的词组id中不存在的，视为删除，输出delete+id
 * 输入：
 *         1-a,2-b,3-c
 *         1-a,2-bb
 *         输出:
 *         modify-2,delete-3
 */
public class First {
}
