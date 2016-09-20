create index IX_F8B609D9 on Hexiagon_Announcement (currencyId);
create index IX_68CF27D7 on Hexiagon_Announcement (groupId, status);
create index IX_EC507202 on Hexiagon_Announcement (typeId);
create index IX_4EE48C8D on Hexiagon_Announcement (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_9950D24F on Hexiagon_Announcement (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_32C092C9 on Hexiagon_AnnouncementImage (announcementId, order_);

create unique index IX_F84C8C8C on Hexiagon_Favorite (announcementId, userId, groupId);
create index IX_4B56C782 on Hexiagon_Favorite (userId, groupId);

create index IX_8C8FB61E on Hexiagon_Type (groupId);