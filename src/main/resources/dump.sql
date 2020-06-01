--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2
-- Dumped by pg_dump version 12.2

-- Started on 2020-06-01 22:07:56

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 211 (class 1259 OID 16840)
-- Name: t_cars; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.t_cars (
    id bigint NOT NULL,
    brand character varying(32) NOT NULL,
    model character varying(32) NOT NULL,
    category_id bigint NOT NULL,
    image text NOT NULL,
    price bigint NOT NULL
);


ALTER TABLE public.t_cars OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16838)
-- Name: t_cars_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.t_cars_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.t_cars_id_seq OWNER TO postgres;

--
-- TOC entry 2882 (class 0 OID 0)
-- Dependencies: 210
-- Name: t_cars_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.t_cars_id_seq OWNED BY public.t_cars.id;


--
-- TOC entry 209 (class 1259 OID 16832)
-- Name: t_categories; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.t_categories (
    id bigint NOT NULL,
    name character varying(30) NOT NULL
);


ALTER TABLE public.t_categories OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 16830)
-- Name: t_categories_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.t_categories_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.t_categories_id_seq OWNER TO postgres;

--
-- TOC entry 2883 (class 0 OID 0)
-- Dependencies: 208
-- Name: t_categories_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.t_categories_id_seq OWNED BY public.t_categories.id;


--
-- TOC entry 205 (class 1259 OID 16799)
-- Name: t_roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.t_roles (
    id bigint NOT NULL,
    name character varying(30) NOT NULL
);


ALTER TABLE public.t_roles OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16797)
-- Name: t_roles_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.t_roles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.t_roles_id_seq OWNER TO postgres;

--
-- TOC entry 2884 (class 0 OID 0)
-- Dependencies: 204
-- Name: t_roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.t_roles_id_seq OWNED BY public.t_roles.id;


--
-- TOC entry 203 (class 1259 OID 16788)
-- Name: t_users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.t_users (
    id bigint NOT NULL,
    full_name character varying(50) NOT NULL,
    date_of_birthday date NOT NULL,
    login character varying(30) NOT NULL,
    password text NOT NULL
);


ALTER TABLE public.t_users OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16786)
-- Name: t_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.t_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.t_user_id_seq OWNER TO postgres;

--
-- TOC entry 2885 (class 0 OID 0)
-- Dependencies: 202
-- Name: t_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.t_user_id_seq OWNED BY public.t_users.id;


--
-- TOC entry 207 (class 1259 OID 16807)
-- Name: t_users_roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.t_users_roles (
    id bigint NOT NULL,
    user_id bigint NOT NULL,
    role_id bigint NOT NULL
);


ALTER TABLE public.t_users_roles OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 16805)
-- Name: t_users_roles_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.t_users_roles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.t_users_roles_id_seq OWNER TO postgres;

--
-- TOC entry 2886 (class 0 OID 0)
-- Dependencies: 206
-- Name: t_users_roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.t_users_roles_id_seq OWNED BY public.t_users_roles.id;


--
-- TOC entry 2717 (class 2604 OID 16843)
-- Name: t_cars id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_cars ALTER COLUMN id SET DEFAULT nextval('public.t_cars_id_seq'::regclass);


--
-- TOC entry 2716 (class 2604 OID 16835)
-- Name: t_categories id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_categories ALTER COLUMN id SET DEFAULT nextval('public.t_categories_id_seq'::regclass);


--
-- TOC entry 2714 (class 2604 OID 16802)
-- Name: t_roles id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_roles ALTER COLUMN id SET DEFAULT nextval('public.t_roles_id_seq'::regclass);


--
-- TOC entry 2713 (class 2604 OID 16791)
-- Name: t_users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_users ALTER COLUMN id SET DEFAULT nextval('public.t_user_id_seq'::regclass);


--
-- TOC entry 2715 (class 2604 OID 16810)
-- Name: t_users_roles id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_users_roles ALTER COLUMN id SET DEFAULT nextval('public.t_users_roles_id_seq'::regclass);


--
-- TOC entry 2876 (class 0 OID 16840)
-- Dependencies: 211
-- Data for Name: t_cars; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.t_cars (id, brand, model, category_id, image, price) FROM stdin;
53	Автомобиль2	Автомобиль2	38	/resources/images/cabriolet.png	80000
54	Автомобиль3	Автомобиль3	39	/resources/images/sport_car.png	100000
55	Автомобиль4	Автомобиль4	37	/resources/images/suv.png	30000
52	Автомобиль1	Автомобиль1	37	/resources/images/sedan.png	50000
56	Автомобиль5	Автомобиль5	37	/resources/images/cabriolet.png	85000
57	Автомобиль6	Автомобиль6	37	/resources/images/sport_car.png	73000
58	Автомобиль7	Автомобиль7	39	/resources/images/sedan.png	10000
\.


--
-- TOC entry 2874 (class 0 OID 16832)
-- Dependencies: 209
-- Data for Name: t_categories; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.t_categories (id, name) FROM stdin;
37	Категория1
38	Категория2
39	Категория3
\.


--
-- TOC entry 2870 (class 0 OID 16799)
-- Dependencies: 205
-- Data for Name: t_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.t_roles (id, name) FROM stdin;
2	Manager
1	Admin
\.


--
-- TOC entry 2868 (class 0 OID 16788)
-- Dependencies: 203
-- Data for Name: t_users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.t_users (id, full_name, date_of_birthday, login, password) FROM stdin;
21	admin	1993-02-18	admin	$2a$10$PQCJJwz9AQ16MQ8LwgEY9.mi.IEsmo.D6XjETezvuhtbQwlbk3uda
22	manager	2000-07-29	manager	$2a$10$nuYHVta336uH8.ljnID6P.3a3wMfi.dAdSncj1Scus6H.WFP8rwVC
\.


--
-- TOC entry 2872 (class 0 OID 16807)
-- Dependencies: 207
-- Data for Name: t_users_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.t_users_roles (id, user_id, role_id) FROM stdin;
40	21	1
44	22	2
\.


--
-- TOC entry 2887 (class 0 OID 0)
-- Dependencies: 210
-- Name: t_cars_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.t_cars_id_seq', 59, true);


--
-- TOC entry 2888 (class 0 OID 0)
-- Dependencies: 208
-- Name: t_categories_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.t_categories_id_seq', 40, true);


--
-- TOC entry 2889 (class 0 OID 0)
-- Dependencies: 204
-- Name: t_roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.t_roles_id_seq', 3, true);


--
-- TOC entry 2890 (class 0 OID 0)
-- Dependencies: 202
-- Name: t_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.t_user_id_seq', 22, true);


--
-- TOC entry 2891 (class 0 OID 0)
-- Dependencies: 206
-- Name: t_users_roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.t_users_roles_id_seq', 46, true);


--
-- TOC entry 2735 (class 2606 OID 16860)
-- Name: t_cars t_cars_brand_model_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_cars
    ADD CONSTRAINT t_cars_brand_model_key UNIQUE (brand, model);


--
-- TOC entry 2737 (class 2606 OID 16848)
-- Name: t_cars t_cars_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_cars
    ADD CONSTRAINT t_cars_pkey PRIMARY KEY (id);


--
-- TOC entry 2731 (class 2606 OID 16855)
-- Name: t_categories t_categories_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_categories
    ADD CONSTRAINT t_categories_name_key UNIQUE (name);


--
-- TOC entry 2733 (class 2606 OID 16837)
-- Name: t_categories t_categories_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_categories
    ADD CONSTRAINT t_categories_pkey PRIMARY KEY (id);


--
-- TOC entry 2723 (class 2606 OID 16814)
-- Name: t_roles t_roles_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_roles
    ADD CONSTRAINT t_roles_name_key UNIQUE (name);


--
-- TOC entry 2725 (class 2606 OID 16804)
-- Name: t_roles t_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_roles
    ADD CONSTRAINT t_roles_pkey PRIMARY KEY (id);


--
-- TOC entry 2719 (class 2606 OID 16796)
-- Name: t_users t_user_login_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_users
    ADD CONSTRAINT t_user_login_key UNIQUE (login);


--
-- TOC entry 2721 (class 2606 OID 16793)
-- Name: t_users t_user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_users
    ADD CONSTRAINT t_user_pkey PRIMARY KEY (id);


--
-- TOC entry 2727 (class 2606 OID 16812)
-- Name: t_users_roles t_users_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_users_roles
    ADD CONSTRAINT t_users_roles_pkey PRIMARY KEY (id);


--
-- TOC entry 2729 (class 2606 OID 16896)
-- Name: t_users_roles t_users_roles_user_id_role_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_users_roles
    ADD CONSTRAINT t_users_roles_user_id_role_id_key UNIQUE (user_id, role_id);


--
-- TOC entry 2740 (class 2606 OID 16890)
-- Name: t_cars t_cars_category_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_cars
    ADD CONSTRAINT t_cars_category_id_fkey FOREIGN KEY (category_id) REFERENCES public.t_categories(id) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;


--
-- TOC entry 2738 (class 2606 OID 16820)
-- Name: t_users_roles t_users_roles_role_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_users_roles
    ADD CONSTRAINT t_users_roles_role_id_fkey FOREIGN KEY (role_id) REFERENCES public.t_roles(id) NOT VALID;


--
-- TOC entry 2739 (class 2606 OID 16825)
-- Name: t_users_roles t_users_roles_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_users_roles
    ADD CONSTRAINT t_users_roles_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.t_users(id) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;


-- Completed on 2020-06-01 22:07:57

--
-- PostgreSQL database dump complete
--

