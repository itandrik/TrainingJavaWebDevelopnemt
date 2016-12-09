-- 1) Написать запрос, считающий суммарное количество имеющихся
--    на сайте новостей и обзоров.
SELECT SUM(quantity) AS 'SUM' FROM(
	SELECT COUNT(*) AS quantity FROM news
    UNION
    SELECT COUNT(*) AS quantity FROM reviews
) T;

-- 2) Написать запрос, показывающий список категорий новостей
--    и количество новостей в каждой категории.
SELECT nc_name, COUNT(n_id) FROM(
	news_categories LEFT JOIN news ON news_categories.nc_id=news.n_category
) GROUP BY nc_name HAVING COUNT(*) >=1 ORDER BY nc_id ASC;

-- 3) Написать запрос, показывающий список категорий обзоров и
--    количество обзоров в каждой категории.
SELECT rc_name, COUNT(r_id) FROM(
	reviews_categories LEFT JOIN reviews ON reviews_categories.rc_id=reviews.r_category
) GROUP BY rc_name HAVING COUNT(*) >=1 ORDER BY rc_id ASC;

-- 4) Написать запрос, показывающий список категорий новостей,
--    категорий обзоров и дату самой свежей публикации в каждой категории.
SELECT category_name, last_date FROM(
	SELECT nc_name AS category_name, n_dt AS last_date FROM(
		news_categories JOIN news ON news_categories.nc_id=news.n_category
    ) 
    UNION DISTINCT
    SELECT rc_name AS category_name, r_dt AS last_date FROM(
		reviews_categories JOIN reviews ON reviews_categories.rc_id=reviews.r_category
    ) ORDER BY last_date DESC 
) T  GROUP BY category_name;

-- 5) Написать запрос, показывающий список страниц сайта верхнего уровня
--    (у таких страниц нет родительской страницы) и список баннеров для
--    каждой такой страницы.
SELECT p_name, b_id, b_url FROM (
	banners JOIN (
		pages JOIN m2m_banners_pages USING(p_id)
	) USING(b_id)
) WHERE pages.p_parent IS NULL;

-- 6) Написать запрос, показывающий список страниц сайта, на которых есть баннеры.
SELECT DISTINCT p_name FROM(
	pages JOIN m2m_banners_pages USING(p_id)
) as T;

-- 7) Написать запрос, показывающий список страниц сайта, на которых нет баннеров.
SELECT p_name FROM pages WHERE p_id NOT IN (
	SELECT DISTINCT p_id FROM(
		pages JOIN m2m_banners_pages USING(p_id)
	)
);

-- 8) Написать запрос, показывающий список баннеров, размещённых хотя
--    бы на одной странице сайта.
SELECT DISTINCT b_id, b_url FROM (
	banners RIGHT JOIN m2m_banners_pages USING(b_id)
);

-- 9) Написать запрос, показывающий список баннеров, не размещённых ни
--    на одной странице сайта.
SELECT b_id, b_url FROM banners WHERE b_id NOT IN (
	SELECT DISTINCT b_id FROM (
		banners RIGHT JOIN m2m_banners_pages USING(b_id)
	)
);

-- 10) Написать запрос, показывающий баннеры, для которых отношение
--     кликов к показам >= 80% (при условии, что баннер был показан хотя бы один раз).
SELECT b_id, b_url, (100 * b_click / b_show) AS rate FROM banners HAVING rate >= 80;

-- 11) Написать запрос, показывающий список страниц сайта, на которых
--     показаны баннеры с текстом (в поле `b_text` не NULL).
SELECT DISTINCT p_name FROM (
	SELECT p_name, b_text FROM 
		(banners JOIN (
			pages JOIN m2m_banners_pages USING(p_id) 
		) USING(b_id)
	) WHERE b_text IS NOT NULL
) T;

-- 12) Написать запрос, показывающий список страниц сайта, на которых показаны
--     баннеры с картинкой (в поле `b_pic` не NULL).
SELECT DISTINCT p_name FROM (
	SELECT p_name, b_text FROM 
		(banners JOIN (
			pages JOIN m2m_banners_pages USING(p_id) 
		) USING(b_id)
	) WHERE b_pic IS NOT NULL
) T;

-- 13) Написать запрос, показывающий список публикаций (новостей и обзоров)
--     за 2011-й год.
SELECT `header`, `date` FROM(
	SELECT n_header as `header`, n_dt as `date` FROM news
    UNION
    SELECT r_header as `header`, r_dt as `date` FROM reviews
) T WHERE EXTRACT(YEAR FROM `date`) = 2011;

-- 14) Написать запрос, показывающий список категорий публикаций
--     (новостей и обзоров), в которых нет публикаций.
SELECT nc_name as category FROM(
	news_categories nc LEFT JOIN news n ON nc.nc_id=n.n_category
) where n_category IS NULL
UNION
SELECT rc_name as category FROM(
	reviews_categories rc LEFT JOIN reviews r ON rc.rc_id=r.r_category
) where r_category IS NULL;

-- 15) Написать запрос, показывающий список новостей из категории
--     «Логистика» за 2012-й год.
SELECT n_header, n_dt FROM(
	news_categories nc JOIN news n ON nc.nc_id=n.n_category
) WHERE nc_name="Логистика" AND EXTRACT(YEAR FROM n_dt) = 2012;

-- 16) Написать запрос, показывающий список годов, за которые есть новости,
--     а также количество новостей за каждый из годов.
SELECT EXTRACT(YEAR FROM n_dt) as `year`, count(*) FROM news group by `year`;

-- 17) Написать запрос, показывающий URL и id таких баннеров, где для одного
--     и того же URL есть несколько баннеров.
SELECT b_url, b_id FROM banners WHERE b_url IN(
	SELECT b_url FROM banners GROUP BY b_url HAVING count(*) > 1
);

-- 18) Написать запрос, показывающий список непосредственных подстраниц
--     страницы «Юридическим лицам» со списком баннеров этих подстраниц.
SELECT p_name, b_id, b_url FROM(
	pages JOIN (
		m2m_banners_pages JOIN banners USING(b_id)
	) USING(p_id)
) WHERE p_parent = (	-- p_parent = 1
	SELECT p_id FROM pages WHERE p_name="Юридическим лицам"
  );

-- 19) Написать запрос, показывающий список всех баннеров с картинками
--     (поле `b_pic` не NULL), отсортированный по убыванию отношения кликов
--     по баннеру к показам баннера.
SELECT b_id, b_url, (b_click / b_show) AS `rate` FROM banners
WHERE b_pic IS NOT NULL ORDER BY `rate` DESC;

/*
 20) Написать запрос, показывающий самую старую публикацию на сайте
     (не важно – новость это или обзор).
*/
SELECT `header`, `date` FROM(
	SELECT n_header as `header`, n_dt as `date` FROM news
	UNION
	SELECT r_header as `header`, r_dt as `date` FROM reviews
) T ORDER BY `date` ASC LIMIT 1;

/* 21) Написать запрос, показывающий список баннеров, URL которых
	   встречается в таблице один раз.
*/
SELECT b_url, b_id FROM banners GROUP BY b_url HAVING COUNT(*) = 1;

/*
   22) Написать запрос, показывающий список страниц сайта в порядке
       убывания количества баннеров, расположенных на странице.
	   Для случаев, когда на нескольких страницах расположено одинаковое
       количество баннеров, этот список страниц должен быть отсортирован
       по возрастанию имён страниц.
*/
SELECT p_name, count(*) as `banners_count` FROM (
	pages JOIN m2m_banners_pages USING(p_id)
) GROUP BY p_name ORDER BY `banners_count` DESC, p_name ASC; 

/*
	23) Написать запрос, показывающий самую «свежую» новость и самый «свежий» обзор.
*/
(SELECT n_header as `header`, n_dt as `date` FROM news
	 ORDER BY n_dt DESC LIMIT 1 )
UNION 
(SELECT r_header as `header`, r_dt as `date` FROM reviews
	ORDER BY r_dt DESC LIMIT 1);
    
/*
	24) Написать запрос, показывающий баннеры, в тексте которых
		встречается часть URL, на который ссылается баннер.
*/
SELECT b_id, b_url, b_text FROM banners WHERE b_url LIKE CONCAT('%',LOWER(b_text),'%');

/*
	25) Написать запрос, показывающий страницу, на которой размещён баннер с самым
		высоким отношением кликов к показам.
*/
SELECT p_name FROM(
	pages JOIN(
		m2m_banners_pages JOIN banners USING(b_id)
	) USING(p_id)
) ORDER BY (b_click/b_show) DESC LIMIT 1;

/*
	26) Написать запрос, считающий среднее отношение кликов к показам по всем
		баннерам, которые были показаны хотя бы один раз.
*/