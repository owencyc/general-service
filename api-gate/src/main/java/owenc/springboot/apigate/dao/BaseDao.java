package owenc.springboot.apigate.dao;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * mybatis-spring 1.2 以后 必须要注入 sqlsessionFactory
 */
@Component
public class BaseDao<T> extends SqlSessionDaoSupport {
    protected String base_path = "cowenc.springboot.apigate.dao";

    @Override
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    /**
     * 新增
     * @param obj
     * @param <T>
     * @return
     * @throws SQLException
     */
    @Transactional(rollbackFor = Exception.class)
    public <T> int add(T obj) throws SQLException {
        return getSqlSession().insert(getSql("add", obj.getClass().getSimpleName()), obj);
    }

    /**
     * 修改 (包含删除)
     * @param obj
     * @param <T>
     * @return
     * @throws SQLException
     */
    @Transactional(rollbackFor = Exception.class)
    public <T> int update(T obj) throws SQLException {
        return getSqlSession().update(getSql("update", obj.getClass().getSimpleName()), obj);
    }

    /**
     * 根据id查询单个对象
     * @param clazz
     * @param id
     * @param <T>
     * @return
     * @throws SQLException
     */
    public <T> T queryOne(Class clazz, Integer id) throws SQLException {
        return getSqlSession().selectOne(getSql("queryOne", clazz.getSimpleName()), id);
    }

    /**
     * 查询所有数量
     * @param clazz
     * @param condition
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public long queryCount(Class clazz, Map<String, Object> condition) {
        return getSqlSession().selectOne(getSql("queryCount", clazz.getSimpleName()), condition);
    }
    @Transactional(rollbackFor = Exception.class)
    public long queryCount(String queryCountSqlID, Map<String, Object> condition) {
        return getSqlSession().selectOne(queryCountSqlID, condition);
    }

    /**
     * 查询所有列表,不带分页
     * @param clazz
     * @param condition
     * @param <T>
     * @return
     * @throws SQLException
     */
    public <T> List<T> queryAll(Class clazz, Map<String, Object> condition) throws SQLException{
        PageList<T> pageList = queryPage(clazz, condition);
        return pageList.getData();
    }

    /**
     * 查询分页列表  通过反射动态查询
     * @param clazz
     * @param condition
     * @param <T>
     * @return
     * @throws SQLException
     */
    public <T> PageList<T> queryPage(Class clazz, Map<String, Object> condition) throws SQLException {
        String sqlCount = getSql("queryCount", clazz.getSimpleName());
        String sqlAll = getSql("queryAll", clazz.getSimpleName());
        return pageList( condition, sqlCount, sqlAll);
    }

    /**
     * 查询分页列表  通过传入固定sql查询
     * @param queryCountSql
     * @param queryAllSql
     * @param condition
     * @param <T>
     * @return
     * @throws SQLException
     */
    public <T> PageList<T> queryPage(String queryCountSql, String queryAllSql, Map<String, Object> condition) throws SQLException {
        return pageList( condition, queryCountSql, queryAllSql);
    }


    private String getSql(String type, String className) {
        switch (type) {
            case "add":
                return base_path + "." + className + "Mapper.add";
            case "update":
                return base_path + "." + className + "Mapper.update";
            case "queryOne":
                return base_path + "." + className + "Mapper.queryOne";
            case "queryCount":
                return base_path + "." + className + "Mapper.queryCount";
            case "queryAll":
                return base_path + "." + className + "Mapper.queryAll";

        }
        throw new RuntimeException("操作异常!");
    }

    private <T> PageList<T> pageList(Map<String, Object> condition,String queryCountSql,String queryAllSql) {
        PageList<T> pageList = new PageList<>();
        if (condition == null) {
            condition = new HashMap<>();
        }

        Page page = null;
        if (Utils.allNotEmpty(condition.get("currentPage"), condition.get("pageSize"))) {
            page = new Page();
            page.setCurrentPage(Integer.parseInt(condition.get("currentPage").toString()));
            page.setPageSize(Integer.parseInt(condition.get("pageSize").toString()));
        }

        if (page != null) {
            long totalCount = getSqlSession().selectOne(queryCountSql, condition);
            condition.put("rowIndex", (page.getCurrentPage()-1) * page.getPageSize());
            condition.put("pageSize", page.getPageSize());

            pageList.setTotalCount(totalCount);
            pageList.setPageSize(page.getPageSize());
            pageList.setCurrentPage(page.getCurrentPage());
        }
        List<T> list = getSqlSession().selectList(queryAllSql, condition);
        pageList.setData(list);
        return pageList;
    }


}