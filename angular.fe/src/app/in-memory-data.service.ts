import { InMemoryDbService } from 'angular-in-memory-web-api';
import { XDate } from './util/xdate';
import { User } from './model/user.model';
import { Subject } from './model/subject.model';
import { Homework } from './model/homework.model';

export class InMemoryDataService implements InMemoryDbService {
  createDb() {


    const users = [
      {
        id: 1, name: 'Roberta', surname: 'Brancatelli', username: 'branca',
        password: 'branca', email: 'roberta.brancatelli@gmail.com', role: 'teacher', sex: 'f'
      },
      {
        id: 2, name: 'Giorgia', surname: 'Bolognesi', username: 'gio',
        password: 'gio', email: 'giorgiabolo05@gmail.com', role: 'scholar', sex: 'f'
      },
      {
        id: 23, name: 'Marco', surname: 'Bolognesi', username: 'bolo',
        password: 'bolo', email: 'bolognesi.marco@gmail.com', role: 'headmaster', sex: 'm'
      }
    ];


    const userclasses = [
      {
        id: 23, schoolclasses: [
          {
            id: 1, name: 'Nistri, II A',
            weekDaySchedules: [
              {
                dayOfWeek: 1, subjects: [
                  { id: 1, name: 'Tecnica' },
                  { id: 1, name: 'Tecnica' },
                  { id: 2, name: 'Grammatica' },
                  { id: 3, name: 'Religione' },
                  { id: 4, name: 'Aritmetica' },
                  { id: 2, name: 'Grammatica' }]
              },
              {
                dayOfWeek: 2, subjects: [
                  { id: 5, name: 'Inglese' },
                  { id: 6, name: 'Musica' },
                  { id: 7, name: 'Spagnolo' },
                  { id: 4, name: 'Aritmetica' },
                  { id: 8, name: 'Motoria' },
                  { id: 9, name: 'Storia' }]
              }
            ],
            subjects: [
              { id: 1, name: 'Tecnica', teacher: { id: 1, username: 'branca' } },
              { id: 2, name: 'Grammatica', teacher: { id: 1, username: 'branca' } },
              { id: 3, name: 'Religione', teacher: { id: 1, username: 'branca' } },
              { id: 4, name: 'Aritmetica', teacher: { id: 1, username: 'branca' } },
              { id: 5, name: 'Inglese', teacher: { id: 1, username: 'branca' } },
              { id: 6, name: 'Musica', teacher: { id: 1, username: 'branca' } },
              { id: 7, name: 'Spagnolo', teacher: { id: 1, username: 'branca' } },
              { id: 8, name: 'Motoria', teacher: { id: 1, username: 'branca' } },
              { id: 9, name: 'Storia', teacher: { id: 1, username: 'branca' } }
            ]
          }
        ]
      }
    ];



    const classes = [
      {
        id: 1, name: 'Nistri, II A',
        weekDaySchedules: [
          {
            dayOfWeek: 1, subjects: [
              { id: 1, name: 'Tecnica' },
              { id: 1, name: 'Tecnica' },
              { id: 2, name: 'Grammatica' },
              { id: 3, name: 'Religione' },
              { id: 4, name: 'Aritmetica' },
              { id: 2, name: 'Grammatica' }]
          },
          {
            dayOfWeek: 2, subjects: [
              { id: 5, name: 'Inglese' },
              { id: 6, name: 'Musica' },
              { id: 7, name: 'Spagnolo' },
              { id: 4, name: 'Aritmetica' },
              { id: 8, name: 'Motoria' },
              { id: 9, name: 'Storia' }]
          }
        ],
        subjects: [
          { id: 1, name: 'Tecnica', teacher: { id: 1, username: 'branca' } },
          { id: 2, name: 'Grammatica', teacher: { id: 1, username: 'branca' } },
          { id: 3, name: 'Religione', teacher: { id: 1, username: 'branca' } },
          { id: 4, name: 'Aritmetica', teacher: { id: 1, username: 'branca' } },
          { id: 5, name: 'Inglese', teacher: { id: 1, username: 'branca' } },
          { id: 6, name: 'Musica', teacher: { id: 1, username: 'branca' } },
          { id: 7, name: 'Spagnolo', teacher: { id: 1, username: 'branca' } },
          { id: 8, name: 'Motoria', teacher: { id: 1, username: 'branca' } },
          { id: 9, name: 'Storia', teacher: { id: 1, username: 'branca' } }
        ]
      }
    ];









    // const subjects: Array<Subject> = [
    //   {id: 1, name: "Tecnica"},
    //   {id: 2, name: "Grammatica"},
    //   {id: 3, name: "Religione"},
    //   {id: 4, name: "Aritmetica"},
    //   {id: 5, name: "Grammatica"},
    //   {id: 6, name: "Inglese"},
    //   {id: 7, name: 'Musica'},
    //   {id: 8, name: 'Spagnolo'},
    //   {id: 9, name: 'Motoria'},
    //   {id: 10, name: 'Storia'},
    //   {id: 11, name: 'Geometria'},
    //   {id: 12, name: 'Antologia'},
    //   {id: 13, name: 'Arte'},
    //   {id: 14, name: 'Approfondimento'},
    //   {id: 15, name: 'Letteratura'},
    //   {id: 16, name: 'Scienze'},
    //   {id: 17, name: 'Geografia'}
    // ];
    // const diaries: Array<Diary> = [
    //   {
    //     id: 1, 
    //     school: 'Nistri',
    //     class: 'IIB',
    //     student: 1,
    //     schedule: [
    //       {id: 1, dayOfWeek: 1, subjects:[1, 1, 2, 3, 4, 5]},
    //       {id: 2, dayOfWeek: 2, subjects:[6, 7, 8, 4, 9, 10]},
    //       {id: 3, dayOfWeek: 3, subjects:[11, 11, 12, 10, 13, 13]},
    //       {id: 4, dayOfWeek: 4, subjects:[14, 8, 15, 15, 7, 6]},
    //       {id: 5, dayOfWeek: 5, subjects: [6, 9, 17, 17, 16, 16]}
    //     ]
    //   }
    // ];
    // const homeworks: Array<Homework> = [
    //   {id : 1, subject:  7, description: 'ripassare fatti mandare dalla mamma', done: true},
    //   {id : 2, subject: 11, description: 'studiare appunti; es pg277 n120 + pg280 n 162 + pg282 n 181, 186, 191', done: true},
    //   {id : 3, subject: 12, description: 'riassunto e domande, pg354 a 357', done: true},
    //   {id : 4, subject: 13, description: 'copiare app su quaderno', done: true},
    //   {id : 5, subject: 15, description: 'riassunto pg 40, 41, 42', done: true},
    //   {id : 6, subject:  7, description: 'stampare foto organo, scheda tecnica organo, pag. 58, 60-62', done: true},
    //   {id : 7, subject: 17, description: 'cartina spagna, pg 58', done: true},
    //   {id : 8, subject: 16, description: 'ripasso 104', done: true},
    //   {id : 9, subject:  8, description: 'studiare pg 108 e a pag 109 es. 7 e 8A', done: true},
    //   {id :10, subject: 16, description: 'ripasso 104', done: false},
    //   {id :11, subject:  6, description: 'pagina 12, tradurre + domande', done: true},
    //   {id :12, subject:  1, description: 'vedi sito', done: false},
    //   {id :13, subject:  2, description: 'studiare da 499 a 503, es pg504 n4-5, pg505 es 9-10, pg506 n 12-13, pg507 n15-16', done: false},
    //   {id :14, subject:  4, description: 'pg322 es 1, 7, 12, 13, 16, 20, 23, 31, pg363 es 141, 143, pg391 es 23, 25 ,26 + VERIFICA', done: false},
    //   {id: 15, subject: 11, description: 'iterrog.: es. pg 277 n115, 121, pg 281 n164, pg 282 n 188', done: false},
    //   {id: 16, subject: 13, description: 'finire disegno', done: false},
    //   {id: 17, subject: 12, description: '...', done: false},
    //   {id: 18, subject: 10, description: '...', done: false}
    // ];


    return { users, userclasses };
  }
}