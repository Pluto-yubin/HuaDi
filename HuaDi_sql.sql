PGDMP     9                    x            HuaDi    12.2    12.2                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    17048    HuaDi    DATABASE     �   CREATE DATABASE "HuaDi" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Chinese (Simplified)_China.936' LC_CTYPE = 'Chinese (Simplified)_China.936';
    DROP DATABASE "HuaDi";
                postgres    false            �            1255    17129    delete_feedback()    FUNCTION     �   CREATE FUNCTION public.delete_feedback() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
 begin
 	if(tg_op = 'DELETE') then
 	delete from feedback where feedback.fid = old.id;
 	end if;
	return old;
 end;
 $$;
 (   DROP FUNCTION public.delete_feedback();
       public          postgres    false            �            1259    17116    feedback    TABLE     c   CREATE TABLE public.feedback (
    msg character varying(50) NOT NULL,
    fid integer NOT NULL
);
    DROP TABLE public.feedback;
       public         heap    postgres    false            �            1259    17113    test_c_id_seq    SEQUENCE     v   CREATE SEQUENCE public.test_c_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.test_c_id_seq;
       public          postgres    false            �            1259    17069    file    TABLE     
  CREATE TABLE public.file (
    id integer DEFAULT nextval('public.test_c_id_seq'::regclass) NOT NULL,
    f_name character varying(100) NOT NULL,
    size character varying(50),
    type character varying(50),
    uid integer NOT NULL,
    path character varying
);
    DROP TABLE public.file;
       public         heap    postgres    false    205            �            1259    17086    rent    TABLE     z   CREATE TABLE public.rent (
    "Object" character varying NOT NULL,
    oid integer NOT NULL,
    uid integer NOT NULL
);
    DROP TABLE public.rent;
       public         heap    postgres    false            �            1259    17057    t_user    TABLE     �   CREATE TABLE public.t_user (
    uid integer,
    upassword character varying,
    utype character varying(10),
    unumber character(18)
);
    DROP TABLE public.t_user;
       public         heap    postgres    false                      0    17116    feedback 
   TABLE DATA           ,   COPY public.feedback (msg, fid) FROM stdin;
    public          postgres    false    206                    0    17069    file 
   TABLE DATA           A   COPY public.file (id, f_name, size, type, uid, path) FROM stdin;
    public          postgres    false    203                     0    17086    rent 
   TABLE DATA           2   COPY public.rent ("Object", oid, uid) FROM stdin;
    public          postgres    false    204   =                 0    17057    t_user 
   TABLE DATA           @   COPY public.t_user (uid, upassword, utype, unumber) FROM stdin;
    public          postgres    false    202   h                   0    0    test_c_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.test_c_id_seq', 1, false);
          public          postgres    false    205            �
           2606    17073    file file_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.file
    ADD CONSTRAINT file_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.file DROP CONSTRAINT file_pkey;
       public            postgres    false    203            �
           2606    17077    t_user unique_user_uid 
   CONSTRAINT     P   ALTER TABLE ONLY public.t_user
    ADD CONSTRAINT unique_user_uid UNIQUE (uid);
 @   ALTER TABLE ONLY public.t_user DROP CONSTRAINT unique_user_uid;
       public            postgres    false    202            �
           2620    17130    file delete_feedback    TRIGGER     s   CREATE TRIGGER delete_feedback AFTER DELETE ON public.file FOR EACH ROW EXECUTE FUNCTION public.delete_feedback();
 -   DROP TRIGGER delete_feedback ON public.file;
       public          postgres    false    207    203            �
           2606    17078    file file_uid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.file
    ADD CONSTRAINT file_uid_fkey FOREIGN KEY (uid) REFERENCES public.t_user(uid) ON UPDATE CASCADE ON DELETE CASCADE;
 <   ALTER TABLE ONLY public.file DROP CONSTRAINT file_uid_fkey;
       public          postgres    false    202    203    2705            �
           2606    17094    rent uid    FK CONSTRAINT     e   ALTER TABLE ONLY public.rent
    ADD CONSTRAINT uid FOREIGN KEY (uid) REFERENCES public.t_user(uid);
 2   ALTER TABLE ONLY public.rent DROP CONSTRAINT uid;
       public          postgres    false    2705    204    202                  x������ � �            x������ � �            x�{����sӳ9�8�8��b���� efy         1   x�3�442�|����M �����2�?_������g`S���� ��     