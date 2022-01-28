import { useExpanded, useTable } from 'react-table';
import {Bar, getDatasetAtEvent} from 'react-chartjs-2';
import React  from 'react';

export function Table({ columns: userColumns, data }) {

    const {
      getTableProps,
      getTableBodyProps,
      headerGroups,
      rows,
      prepareRow,
      visibleColumns,
      state: { expanded },
    } = useTable(
      {
        columns: userColumns,
        data,
      },
      useExpanded
    )

    
    function getDataset(row) {
     
     
        return { labels: ['literature', 'rna_expression', 'genetic_association',
                  'somatic_mutation', 'known_drug','animal_model','affected_pathway'],
         datasets: [
           {
             label: 'Association score vs Data Type',
             backgroundColor: '#3489ca',
             borderColor: 'rgba(0,0,0,1)',
             borderWidth: 2,
             data: Object.values(row.original.association_score.datatypes)
           }
         ]
       }
     }
  
    return (
      <>
        <table {...getTableProps()}>
          <thead>
            {headerGroups.map(headerGroup => (
              <tr {...headerGroup.getHeaderGroupProps()}>
                {headerGroup.headers.map(column => (
                  <th {...column.getHeaderProps()}>{column.render('Header')}</th>
                ))}
              </tr>
            ))}
          </thead>
          <tbody {...getTableBodyProps()}>
            {rows.map((row, i) => {
              prepareRow(row)
              return (
                <React.Fragment {...row.getRowProps()}>
                  <tr>
                    {row.cells.map(cell => {
                      return (
                        <td {...cell.getCellProps()}>{cell.render('Cell')}</td>
                      )
                    })}
                  </tr>
                  {row.isExpanded ? (
                    <tr>
                      <td colSpan={visibleColumns.length}>

                      <Bar
                          data={getDataset(row)}
                          options={{
                            title:{
                              display:true,
                              text:'Average Rainfall per month',
                              fontSize:1
                            },
                            legend:{
                              display:true,
                              position:'right'
                            }
                          }}
                        />
                      </td>
                    </tr>
                  ) : null}
                </React.Fragment>
              )
            })}
          </tbody>
        </table>
        <br />
        <div>Showing the first 5 results of {rows.length} rows</div>
      </>
    )
  }