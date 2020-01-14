package org.kimbs.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ExampleRepository {

//    1. 모든 종업원을 찾아라.
//
//    2. 급여가 2000 이상인 종업원의 이름과 급여를 찾아라.
//
//    3. 매니저가 없는 사원의 이름을 찾아라
//
//    4. 가장 많은 급여를 받는 사원의 이름과 급여를 찾으렴 ㅎㅎ
//    -1 select ename, sal from emp where sal >= all (select sal from emp); <= all 사용
//    -2 select ename, sal from emp where = (select max(sal) from emp); <== max 사용
//
//    5. 자신의 매니저보다 더 많은 급여를 받는 사원의 이름과 급여, 매니저의 이름과 급여를 찾아라/
//            - select e1.ename 사원이름, e1.sal 사원급여, e2.ename 매니저이름, e2.sal 매니저급여
//    from emp e1, emp e2 where e1.mgr = e2.empno and e1.sal > e2.sal;
//
//    - 반대  > select e1.ename 사원이름, e1.sal 사원급여, e2.ename 매니저이름, e2.sal 매니저급여
//    from emp e1, emp e2 where e1.mgr = e2.empno and e1.sal < e2.sal;
//
//    6. 'sales' 부서에 근무하는 사원의 이름과 급여를 급여 내림차순 으로 찾아라. 급여가 같을경우 이름 오름차순으로 찾아라.
//    - select ename, sal from emp, ept where emp.deptno = dept.deptno and dept.dname = 'SALES' order by sal desc, ename asc;
//
//    7. 이름에 M가 S가 포함된 사원의 이름을 찾아라.
//    - select ename from emp where ename like '%M%S%' or ename like '%S%M%';
//
//    8. 급여가 두 번째로 많은 사원 이름, 급여 출력
//    select ename, sal from (select rownum tempnum, ename, sal from (select * from emp order by sal desc) e ) b where b.tempnum = 2;

    @Autowired
    private ReactiveMongoTemplate template;

}
