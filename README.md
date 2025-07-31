# 🎨 WerseCustomJoinMessage

Make your server welcome messages stand out!  
This plugin allows you to fully customize **join** and **leave** messages with:
- Permission-based messages
- First join greetings
- HEX color support

## ⚙️ Configuration
```yaml
# Simple join message plugin
# Placeholder %player% will be replacment to players name
# You can also use HEX colors in format &#RRGGBB
# Have Fun!
general:
  join_message: "&7[&a+&7] &e%player% joined the server!"
  leave_message: "&7[&c-&7] &e%player% left the server!"
  first_join:
    enabled: true
    first_join_message: "Welcome %player%! Glad to see you here!"

custom_message:
  1:
    permission: "your.custom.permission"
    join_message: "&7[VIP] &6%player% joined with style!"
    leave_message: "&7[VIP] &6%player% left quietly."
  2:
    permission: "your.admin.permission"
    join_message: "&7[ADMIN] &c%player% is here!"
    leave_message: "&7[ADMIN] &c%player% has left."
```
## 🚀 Installation

- Place the plugin .jar into your plugins folder.

- Start the server to generate the config.

- Customize your messages and permissions.

- Restart the server.