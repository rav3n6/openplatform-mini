import { useExpanded, useTable } from 'react-table';
import {Bar} from 'react-chartjs-2';
import React  from 'react';
import BTable from 'react-bootstrap/Table';

export function Table({ columns: userColumns, data }) {

    const {
      getTableProps,
      getTableBodyProps,
      headerGroups,
      rows,
      prepareRow,
      visibleColumns,
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
        <BTable striped bordered hover size="sm" {...getTableProps()}>
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
              const rowProps = row.getRowProps();
              return (
                <React.Fragment  key={rowProps.key}>
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
                              fontSize:2
                            },
                           // maintainAspectRatio: false,
                            legend:{
                              display:true,
                              position:'right',
                              fontSize:2
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
        </BTable>
        <br />

      </>
    )
  }