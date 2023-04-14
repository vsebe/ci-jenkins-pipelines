targetConfigurations = [
        'x64Mac'      : [
                'openj9'
        ],
        'x64Linux'    : [
                'openj9'
        ],
        'x64Windows'  : [
                'openj9'
        ],
        'ppc64Aix'    : [
                'openj9'
        ],
        'ppc64leLinux': [
                'openj9'
        ],
        's390xLinux'  : [
                'openj9'
        ],
        'aarch64Linux': [
                'openj9'
        ],
        'aarch64Mac': [
                'openj9'
        ]
]

// Weeknights at 1:30 am
triggerSchedule_nightly='30 19 * * 1-4'
// 12pm Sat
triggerSchedule_weekly='59 11 * * 6'

// scmReferences to use for weekly release build
weekly_release_scmReferences=[
    'openj9'         : ''
]

disableJob = true

return this
