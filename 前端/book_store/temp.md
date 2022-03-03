//                              将id = 4的结果集 取别名为t2（表）
SELECT * FROM `t_book` AS t1 JOIN (
    //随机产生一个id 结果集: id = 4  -- round为四舍五入
    SELECT ROUND(
        //随机选一个此表中的id (小数)
        RAND() * (
            //查询此表最大id
            SELECT MAX(id) FROM `t_book`
        )
    ) AS id
) AS t2
//筛选出id比4大的记录
WHERE t1.id >= t2.id
//展示前五hang
ORDER BY t1.id ASC LIMIT 1;