create table Hexiagon_Announcement (
	uuid_ VARCHAR(75) null,
	announcementId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	typeId LONG,
	folderId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	currencyId LONG,
	title STRING null,
	emailAddress VARCHAR(75) null,
	phoneNumber VARCHAR(75) null,
	price LONG,
	content STRING null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	countryId LONG,
	regionId LONG,
	city VARCHAR(75) null,
	site VARCHAR(75) null,
	building VARCHAR(75) null
);

create table Hexiagon_AnnouncementImage (
	announcementImageId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	announcementId LONG,
	fileEntryId LONG,
	description STRING null,
	order_ INTEGER
);

create table Hexiagon_Currency (
	currencyId LONG not null primary key,
	companyId LONG,
	label VARCHAR(75) null,
	symbol VARCHAR(75) null,
	order_ INTEGER,
	countryId LONG,
	rate LONG
);

create table Hexiagon_Favorite (
	favoriteId LONG not null primary key,
	announcementId LONG,
	companyId LONG,
	groupId LONG,
	userId LONG
);

create table Hexiagon_Type (
	typeId LONG not null primary key,
	name STRING null,
	groupId LONG,
	companyId LONG,
	order_ INTEGER
);