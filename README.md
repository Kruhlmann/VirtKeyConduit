# VirtKeyConduit

## Installing

⚠️ This script will run as root so please [inspect it](install) before running. Alternatively, or if you're using Windows, you can download the JAR file directly from the [releases page](https://github.com/Kruhlmann/VirtKeyConduit/releases).

```sh
curl https://raw.githubusercontent.com/Kruhlmann/VirtKeyConduit/master/install | sudo sh
```

## Running

Example keycodes:

```sh
$ vkc Abc us
KEY_LEFTSHIFT KEY_A
KEY_B
KEY_C
```

### Piping into virsh send-key

```
$ vkc Abc us | while read -r key; do printf 'sudo virsh send-key machinename %s\n' "$key"; done | bash - >/dev/null
```

## Layouts

*See /usr/share/vck/keyboards for default keyboards*

Custom keyboards xml files can be read from the system directory or the current directory such that `vkc Abc us` will look for `$(pwd)/us.xml` and `/usr/share/vck/keyboards/us.xml` (the current directory takes precedence).