CREATE TABLE CP_EMP8 as (select * FROM emp);

alter table cp_emp8 add constraint pk_cp_emp8 primary key (empno);

commit;