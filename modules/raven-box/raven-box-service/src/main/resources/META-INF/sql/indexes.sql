create index IX_3BF31271 on ravenbox_Announcement (currencyId);
create index IX_4DD7BE3F on ravenbox_Announcement (groupId, status);
create index IX_F9D9869A on ravenbox_Announcement (typeId);
create index IX_AEEC325 on ravenbox_Announcement (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_6F27CEE7 on ravenbox_Announcement (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_76D2CD31 on ravenbox_AnnouncementImage (announcementId, order_);

create unique index IX_243BF226 on ravenbox_Currency (countryId);

create unique index IX_3C5EC6F4 on ravenbox_Favorite (announcementId, userId, groupId);
create index IX_6FBAD1EA on ravenbox_Favorite (userId, groupId);

create index IX_9D8F64A6 on ravenbox_type (groupId);